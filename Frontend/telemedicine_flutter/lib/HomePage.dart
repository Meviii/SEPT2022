import 'package:flutter/material.dart';
import 'PatientLogin.dart';
import 'DoctorLogin.dart';
import 'AdminLogin.dart';
import 'HelperFunctions.dart';
import 'Patient/Patient_Profile/Patient_Profile_Tab/Profile_screen.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(centerTitle: true, title: const Text('MD Online')),
      body: ListView(children: [
        Center(
          // Navigation buttons
          child: Column(children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
              child: SizedBox(
                width: screenWidth(context) * 0.4,
                height: 50,
                child: ElevatedButton(
                  child: const Text('Admin Login'),
                  onPressed: () {
                    Navigator.push(context,
                        MaterialPageRoute(builder: (context) => AdminLogin()));
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
                  child: const Text('Patient Login'),
                  onPressed: () {
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => PatientLogin()));
                  },
                ),
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(0, 60, 0, 60),
              child: SizedBox(
                width: screenWidth(context) * 0.4,
                height: 50,
                child: ElevatedButton(
                    child: const Text('Doctor Login'),
                    onPressed: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => DoctorLogin()));
                    }),
              ),
            )
          ]),
        ),
      ]),
    );
  }
}
