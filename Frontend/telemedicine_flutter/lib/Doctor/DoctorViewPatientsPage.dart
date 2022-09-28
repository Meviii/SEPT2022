import 'package:flutter/material.dart';
import '../HelperFunctions.dart';
import 'package:http/http.dart' as http;
import '../Model/PatientModel.dart';
import '../Model/AddressModel.dart';
import 'dart:convert';

Future<List<Patient>> fetchPatients() async {

  print("Fetch called.");

  var url = "http://localhost:8082/api/v1/users";

  var response = await http.get(Uri.parse(url),
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Accept": "application/json"
  });

  print("Fetch passed.");

  
  if(response.statusCode == 200) {

    var jsonData = json.decode(response.body);

    List<Patient> patients = [];

    // Temporarily add these patients - replace with for loop once UserModel is complete
    patients.add(Patient.fromJson(jsonData["messages"][0]));
    patients.add(Patient.fromJson(jsonData["messages"][1]));
    

    /*

    // FIX BELOW : by creating a separate doctor and user model

    for(int i = 0; i < jsonData["messages"].length; i++) {
      patients.add(Patient.fromJson(jsonData["messages"][i]));
    }

    */

    return patients;

  } else {
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
      body: FutureBuilder<List<Patient>>(
        future: futurePatients,
        builder: (context, snapshot) {
          if(snapshot.hasData) {
            
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (BuildContext context, int index) {
                return Text(snapshot.data![index].getFirstName);
              }
            );

          } else if(snapshot.hasError) {
            return Text('${snapshot.error}');
          }

          // Show loading spinner by default
          return const CircularProgressIndicator();
        }

      ),
        


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
  
