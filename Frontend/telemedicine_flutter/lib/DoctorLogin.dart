import 'package:flutter/material.dart';
import 'HelperFunctions.dart';

class DoctorLogin extends StatefulWidget {
  const DoctorLogin({super.key});

  @override
  State<DoctorLogin> createState() => _DoctorLoginState();
}


class _DoctorLoginState extends State<DoctorLogin> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Doctor Login")),
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
                      padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
                      child: SizedBox(
                        width: screenWidth(context) * 0.4,
                        height: 50,
                        child: ElevatedButton(
                          onPressed: () {
                            if(_formKey.currentState!.validate()) {
                              // TODO Process data
                            }
                          },
                          child: const Text("Submit")
                        ),
                      ),
                    ),
                  ]
                )
              )
            ),

            // Signup new account button
            Padding(
              padding: const EdgeInsets.fromLTRB(0, 30, 0, 30),
              child: SizedBox(
                width: screenWidth(context) * 0.3,
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
                      context, MaterialPageRoute(builder: (context) => DoctorLogin()));
                  },
                  child: const Text("Register New Account")
                ),
              ),
            ),

          ])
        ),]
      )
    );
  }
}
