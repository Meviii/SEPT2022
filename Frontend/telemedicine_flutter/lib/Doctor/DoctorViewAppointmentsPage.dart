import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../HelperFunctions.dart';
import '../Model/AppointmentModel.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import '../Model/PatientModel.dart';

// TODO : Temp until logged in doctor data can be retrieved
const int currentDoctorId = 4;

Future<List<Appointment>> fetchAppointments() async {

  var url = "http://localhost:8082/api/v1/appointment/";

  var response = await http.get(Uri.parse(url),
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Accept": "application/json"
  });

  List<Appointment> appointments = [];

  if(response.statusCode == 200) {

    var jsonData = json.decode(response.body);
    
    // Iterate through all users, only adding patient user types
    for(int i = 0; i < jsonData.length; i++) {

      if(jsonData[i]["doctorId"] == currentDoctorId.toString()) {
        appointments.add(Appointment.fromJson(jsonData[i]));
      }
    }

    return appointments;

  } else {
    throw Exception("Failed to load appointments.");
  }
}

Future<List<Patient>> fetchPatients(Future<List<Appointment>> appointments) async {

  var url = "http://localhost:8081/api/v1/users";

  var response = await http.get(Uri.parse(url),
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Accept": "application/json"
  });

  if(response.statusCode == 200) {

    var jsonData = json.decode(response.body);

    List<Appointment> myAppointments = await appointments;

    List<Patient> patients = [];
    
    // Iterate through all users, only adding patient user types
    for(int i = 0; i < jsonData["messages"].length; i++) {

      // Check if user type is a patient
      if(jsonData["messages"][i]["userType"] == "Patient") {

        // Check to see if patient has had an appointment with the current doctor
        for(int j = 0; j < myAppointments.length; j++) {
          if(myAppointments.elementAt(j).getPatientId == jsonData["messages"][i]["id"].toString()) {
            patients.add(Patient.fromJson(jsonData["messages"][i]));
            break;
          }
        }
      }
    }

    return patients;

  } else {
    throw Exception("Failed to load patients.");
  }
}

class DoctorViewAppointmentsScreen extends StatefulWidget {
  const DoctorViewAppointmentsScreen({super.key});

  @override
  createState() => DoctorViewAppointmentsState();
}

class DoctorViewAppointmentsState extends State<DoctorViewAppointmentsScreen> {
  late Future<List<Appointment>> futureAppointments;
  late Future<List<Patient>> futurePatients;

  @override
  void initState() {
    super.initState();
    futureAppointments = fetchAppointments();
    futurePatients = fetchPatients(futureAppointments);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Appointments")),
      body: Column(children: [ 

        // Build a list of all appointments
        FutureBuilder<List<Appointment>>(
          future: futureAppointments,
          builder: (context, snapshot) {
            if(snapshot.hasData) {
              
              // List of all current appointments
              return Expanded(
                child: ListView.builder(
                  itemCount: snapshot.data!.length,
                  itemBuilder: (BuildContext context, int index) {

                    return Container(
                      decoration: BoxDecoration(
                        border: Border.all(color: Color.fromARGB(255, 47, 47, 47))
                      ),

                      // Button for viewing/updating appointment time
                      child: Container(
                        decoration: BoxDecoration(
                          border: const Border(
                            bottom: BorderSide(width: 2, color:Color.fromARGB(255, 84, 84, 84)),
                          ),
                          color: Colors.grey[800],
                        ),

                        child: Padding(
                          padding: const EdgeInsets.all(20.0),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [

                              Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text("${DateFormat.jm().format(snapshot.data![index].getStart)} Appointment ${DateFormat.yMd().format(snapshot.data![index].getStart)}"),
                                  Text("with Patient ID: ${snapshot.data![index].getPatientId}")
                                ],
                              ),
                             
                              
                              Row(
                                children: [

                                  // Button for managing an appointment
                                  Padding(
                                    padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
                                    child: SizedBox(
                                      width: screenWidth(context) * 0.15,
                                      height: 30,
                                      child: ElevatedButton(
                                        style: ElevatedButton.styleFrom(
                                          primary: Colors.lightBlue[800],
                                          textStyle: const TextStyle(
                                            fontSize: 12, fontFamily: 'Georgia'
                                          ),
                                        ),
                                        onPressed: () {
                                          Navigator.push(
                                            // TODO enable edit abilities
                                            context, MaterialPageRoute(builder: (context) => const DoctorViewAppointmentsScreen()));
                                        },
                                        child: const Text("Manage")
                                      ),
                                    ),
                                  ),

                                  // Button for cancelling an appointment
                                  SizedBox(
                                    width: screenWidth(context) * 0.15,
                                    height: 30,
                                    child: ElevatedButton(
                                      style: ElevatedButton.styleFrom(
                                        primary: Colors.red[800],
                                        textStyle: const TextStyle(
                                          fontSize: 12, fontFamily: 'Georgia'
                                        ),
                                      ),
                                      onPressed: () {
                                        Navigator.push(
                                          // TODO
                                          context, MaterialPageRoute(builder: (context) => const DoctorViewAppointmentsScreen()));
                                      },
                                      child: const Text("Cancel")
                                    ),
                                  ),

                                ],
                              ),
                            ]),
                        ),
                      ),
                    );
                  }
                )
              );

            } else if(snapshot.hasError) {
              return Text('${snapshot.error}');
            }

            // Show loading spinner by default
            return const CircularProgressIndicator();
          }
        ),

        // Button for making a new appointment
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 20, 0, 60),
          child: SizedBox(
            width: screenWidth(context) * 0.4,
            height: 50,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.lime[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                textStyle: const TextStyle(
                  fontSize: 12, fontFamily: 'Georgia', 
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO enable create abilities
                  context, MaterialPageRoute(builder: (context) => const DoctorViewAppointmentsScreen()));
              },
              child: const Align(
                alignment: Alignment.center,
                child: Text("Make a New Appointment")
              )
            ),
          ),
        ),

      ]),    
    );
  }
}
