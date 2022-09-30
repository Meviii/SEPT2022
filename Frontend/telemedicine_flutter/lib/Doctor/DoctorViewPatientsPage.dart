import 'package:flutter/material.dart';
import '../HelperFunctions.dart';
import 'package:http/http.dart' as http;
import '../Model/PatientModel.dart';
import '../Model/AppointmentModel.dart';
import 'dart:convert';

Future<List<Appointment>> fetchAppointments() async {

  var url = "http://localhost:8082/api/v1/appointment/";

  var response = await http.get(Uri.parse(url),
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Accept": "application/json"
  });

  if(response.statusCode == 200) {

    var jsonData = json.decode(response.body);

    // TODO : Temp until logged in doctor data can be retrieved
    int currentDoctorId = 4;  

    List<Appointment> appointments = [];
    
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

class _DoctorViewPatientsPageState extends State<DoctorViewPatientsPage> {
  late Future<List<Patient>> futurePatients;
  late Future<List<Appointment>> futureAppointments;

  @override
  void initState() {
    super.initState();
    futureAppointments = fetchAppointments();
    futurePatients = fetchPatients(futureAppointments);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Patients")),
      body: FutureBuilder<List<Patient>>(
        future: futurePatients,
        builder: (context, snapshot) {
          if(snapshot.hasData) {
            
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (BuildContext context, int index) {

                return Container(
                  decoration: BoxDecoration(
                    border: Border.all(color: Colors.grey)
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Column( 
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                          Text('${snapshot.data![index].getFirstName} ${snapshot.data![index].getMiddleName} ${snapshot.data![index].getLastName}'),
                          Text('ID: ${snapshot.data![index].getId.toString()}')
                        ]),

                        Row( children: [
                          
                          // Button for managing and viewing the patient details
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
                                    // TODO link this up to register account page
                                    context, MaterialPageRoute(builder: (context) => DoctorViewPatientsPage()));
                                },
                                child: const Text("Manage")
                              ),
                            ),
                          )
                        ])
                      ]
                    ),
                  ),
                );
              }
            );

          } else if(snapshot.hasError) {
            return Text('${snapshot.error}');
          }

          // Show loading spinner by default
          return const CircularProgressIndicator();
        }

      ),
    );
  }
}

class DoctorViewPatientsPage extends StatefulWidget {
  const DoctorViewPatientsPage({super.key});

  @override
  createState() => _DoctorViewPatientsPageState();
}
  
