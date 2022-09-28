import 'package:flutter/material.dart';
import '../HelperFunctions.dart';
import 'package:http/http.dart' as http;
import '../Model/PatientModel.dart';
import 'dart:convert';

Future<List<Patient>> fetchPatients() async {

  print("Fetch called.");

  var url = "localhost:8081/api/v1/user";

  print("Accepted URL");

  var response = await http.get(Uri.parse(url),
  headers: {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Accept": "*/*",
    "Accept-Encoding": "gzip, deflate, br",
    "Connection": "keep-alive"
  });

  print("Fetch passed.");

  
  if(response.statusCode == 200) {

    print("Response code 200.");

    var jsonData = json.decode(response.body);

    List<Patient> patients = [];

    for (var p in jsonData) {
      Patient patient = patientJson(p);
      patients.add(patient);
    }

    // Parse all patients into a list

    /*
    List<Patient> patients = (patientJson(response.body) as List).map((i) => patientJson(i)).toList();
  
    for(Patient p in patients) {
      print(p.getFirstName);
    }
    */

    return patients;

  } else {
    print("Failed connection");
    throw Exception("Failed to load patients.");
  }
}

class _DoctorViewPatientsPageState extends State<DoctorViewPatientsPage> {
  late Future<List<Patient>> futurePatients;


  @override
  void initState() {
    super.initState();
    futurePatients = fetchPatients();
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Patients")),
      body: ListView(children: [ 

        FutureBuilder<List<Patient>>(
          future: futurePatients,
          builder: (context, snapshot) {
            if(snapshot.hasData) {
              
              return Container(
                child: ListView.builder(
                  itemCount: snapshot.data!.length,
                  itemBuilder: (BuildContext context, int index) {
                    return Text(snapshot.data![index].getFirstName);
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
        
        
        // TODO View a list of all patients here

        //foreach (Patient p in Patients) {
        //
        // The padding thing below
        //
        //}

        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row( 
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
            
              // Container holding patient name and ID
              // TODO fix left align
              Padding(
                padding: const EdgeInsets.fromLTRB(20, 0, 0, 0),
                child: Column( children: const [
                  Align(
                    alignment: Alignment.centerLeft,
                    child: Text("Patient Full Name")
                  ),
                  Align(
                    alignment: Alignment.centerLeft,
                    child: Text("Patient ID")
                  ),
                ]),
              ),
              
              
              // Button for managing the selected patient
              Row(
                children: [
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
                  ),
                

                //Button for removing the selected patient
                Padding(
                  padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
                  child: SizedBox(
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
                          // TODO link this up to register account page
                          context, MaterialPageRoute(builder: (context) => DoctorViewPatientsPage()));
                      },
                      child: const Text("Remove")
                    ),
                  ),
                ),
              ]),

          ]),
        ),

      ]),
        


        // Each patient is a row with two buttons : Manage, Remove

        // Remove should clear that patient from the doctor's list

        // Manage goes to the patient profile
        // Patient profile page can then be navigated from a bottom bar for profile, prescriptions, appointments
        // Remove the appbar's 'back button' and replace it with an X that returns to the view patients page
        
        
    
    );
  }
}

class DoctorViewPatientsPage extends StatefulWidget {
  const DoctorViewPatientsPage({super.key});

  @override
  createState() => _DoctorViewPatientsPageState();
}
  
