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

        
        Padding(
          padding: const EdgeInsets.symmetric(vertical: 20.0),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [

              // My Profile button
              SizedBox(
                width: screenWidth(context) * 0.4,
                height: 150,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    primary: Colors.lime[800],
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
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
                    alignment: Alignment.center,
                    child: Text("My Profile")
                  )
                ),
              ),

              // My Patients button
              SizedBox(
                width: screenWidth(context) * 0.4,
                height: 150,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    primary: Colors.lime[800],
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
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
                    alignment: Alignment.center,
                    child: Text("My Patients")
                  )
                ),
              ),

            ],
          ),
        ),

       

        // My Appoinments button
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 0, 20),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [

              SizedBox(
                width: screenWidth(context) * 0.4,
                height: 150,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    primary: Colors.lime[800],
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    textStyle: const TextStyle(
                      fontSize: 16, fontFamily: 'Georgia', 
                    ),
                  ),
                  onPressed: () {
                    Navigator.push(
                      // TODO link this up to register account page
                      context, MaterialPageRoute(builder: (context) => const DoctorViewAppointmentsScreen()));
                  },
                  child: const Align(
                    alignment: Alignment.center,
                    child: Text("My Appointments")
                  )
                ),
              ),

              // My Availabilities button
              SizedBox(
                width: screenWidth(context) * 0.4,
                height: 150,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    primary: Colors.lime[800],
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
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
                    alignment: Alignment.center,
                    child: Text("My Availabilities")
                  )
                ),
              ),

            ],
          ),
        ),

        

        // Chat Menu button
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            
            SizedBox(
              width: screenWidth(context) * 0.4,
              height: 150,
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  primary: Colors.lime[800],
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
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
                  alignment: Alignment.center,
                  child: Text("Chat Online")
                )
              ),
            ),

            SizedBox(width: screenWidth(context) * 0.4)

          ],
        ),
        
      ])
    );
  }
}
