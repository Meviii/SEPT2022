import 'package:flutter/material.dart';
import 'package:telemedicine_flutter/Patient/Patient_Profile/Patient_Profile_Tab/Profile_screen.dart';
import 'HelperFunctions.dart';

class PatientLogin extends StatefulWidget {
  const PatientLogin({super.key});

  @override
  State<PatientLogin> createState() => _PatientLoginState();
}


class _PatientLoginState extends State<PatientLogin> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Patient Login")),
      body: ListView(
        children: [ Center(
          child: Column( children: [

            // Brand image
            Container(
              width: screenWidth(context) * 0.7,
              height: 200,
              color: Colors.red,
              margin: const EdgeInsets.fromLTRB(0, 60, 0, 0),
            ),

            Form(
              key: _formKey,
              child: Center(
                child: Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
                      child: SizedBox(
                        width: screenWidth(context) * 0.6,
                        child: TextFormField(
                          decoration: const InputDecoration(
                            hintText: 'Username',
                          ),
                          validator: (String? value) {
                            if(value == null || value.isEmpty) {
                              return 'Please enter your username';
                            }
                            return null;
                          }
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
                      child: SizedBox(
                        width: screenWidth(context) * 0.6,
                        child: TextFormField(
                          decoration: const InputDecoration(
                            hintText: 'Password',
                          ),
                          validator: (String? value) {
                            if(value == null || value.isEmpty) {
                              return 'Please enter your password';
                            }
                            return null;
                          }
                        ),
                      ),
                    ),
                     Padding(
                      padding: const EdgeInsets.fromLTRB(0, 60, 0, 60),
                      child: SizedBox(
                        width: screenWidth(context) * 0.4,
                        height: 50,
                        child: ElevatedButton(
                          onPressed: () {
                            if(_formKey.currentState!.validate()) {
                              // TODO Process data
                            }
                          },
                          child: const Text("Login")
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(0, 60, 0, 60),
                      child: SizedBox(
                        width: screenWidth(context) * 0.4,
                        height: 50,
                        child: ElevatedButton(
                          onPressed: () {
                            Navigator.push(
                            context,
                            MaterialPageRoute(
                            builder: (context) => Profile_screen()));
                          },
                          child: const Text("Profile")
                        ),
                      ),
                    )
                  ]
                )
              )
            ),
          ])
        ),]
      )
    );
  }
}
