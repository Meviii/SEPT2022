import 'package:flutter/material.dart';
import 'PatientLogin.dart';
import 'HelperFunctions.dart';
import 'Patient/Patient_Profile/Profile_screen.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(centerTitle: true, title: const Text('ND Telemedicine')),
      body: Center( 
        // TODO : add child for brand image here

        // Column for the navigation buttons
        child: Column(children: [
          Padding(
            padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
            child: SizedBox(
              width: screenWidth(context) * 0.4,
              height: 50,
              child: ElevatedButton(
                child: const Text('Admin'),
                onPressed: () => print('Admin button pressed')
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
            child: SizedBox(
              width: screenWidth(context) * 0.4,
              height: 50,
              child: ElevatedButton(
                child: const Text('Patient Login'),
                onPressed: () {
                  Navigator.push(
                    context, MaterialPageRoute(builder: (context) => PatientLogin()));
                },
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
            child: SizedBox(
              width: screenWidth(context) * 0.4,
              height: 50,
              child: ElevatedButton(
                child: const Text('Patient'),
                onPressed: () {
                  Navigator.push(
                    context, MaterialPageRoute(builder: (context) => Profile_screen()));
                }
              ),
            ),
          )
        ]),
      ),
    );
  }
}