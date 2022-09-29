import 'package:flutter/material.dart';
import '../HelperFunctions.dart';
import 'DoctorViewPatientsPage.dart';
import 'DoctorViewProfilePage.dart';
import 'DoctorViewAppointmentsPage.dart';
import 'DoctorViewAvailabilitiesPage.dart';

class DoctorMainPage extends StatelessWidget {
  const DoctorMainPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("MD Telemedicine")),
      body: ListView(children: [ 

        // My Profile button
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
          child: SizedBox(
            width: screenWidth(context),
            height: 50,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.red[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(0)),
                textStyle: const TextStyle(
                  fontSize: 16, fontFamily: 'Georgia', 
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO link this up to register account page
                  context, MaterialPageRoute(builder: (context) => DoctorViewProfilePage()));
              },
              child: const Align(
                alignment: Alignment.centerLeft,
                child: Text("My Profile")
              )
            ),
          ),
        ),

        // My Patients button
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
          child: SizedBox(
            width: screenWidth(context),
            height: 50,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.red[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(0)),
                textStyle: const TextStyle(
                  fontSize: 16, fontFamily: 'Georgia', 
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO link this up to register account page
                  context, MaterialPageRoute(builder: (context) => DoctorViewPatientsPage()));
              },
              child: const Align(
                alignment: Alignment.centerLeft,
                child: Text("My Patients")
              )
            ),
          ),
        ),

        // My Appoinments button
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
          child: SizedBox(
            width: screenWidth(context),
            height: 50,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.red[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(0)),
                textStyle: const TextStyle(
                  fontSize: 16, fontFamily: 'Georgia', 
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO link this up to register account page
                  context, MaterialPageRoute(builder: (context) => DoctorViewAppointmentsPage()));
              },
              child: const Align(
                alignment: Alignment.centerLeft,
                child: Text("My Appointments")
              )
            ),
          ),
        ),

        // My Availabilities button
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
          child: SizedBox(
            width: screenWidth(context),
            height: 50,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.red[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(0)),
                textStyle: const TextStyle(
                  fontSize: 16, fontFamily: 'Georgia', 
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO link this up to register account page
                  context, MaterialPageRoute(builder: (context) => DoctorViewAvailabilitiesPage()));
              },
              child: const Align(
                alignment: Alignment.centerLeft,
                child: Text("My Availabilities")
              )
            ),
          ),
        ),

        // Chat Menu button
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
          child: SizedBox(
            width: screenWidth(context),
            height: 50,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.red[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(0)),
                textStyle: const TextStyle(
                  fontSize: 16, fontFamily: 'Georgia', 
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO link this up to register account page
                  context, MaterialPageRoute(builder: (context) => DoctorMainPage()));
              },
              child: const Align(
                alignment: Alignment.centerLeft,
                child: Text("Chat Online")
              )
            ),
          ),
        ),
        
      ])
    );
  }
}
