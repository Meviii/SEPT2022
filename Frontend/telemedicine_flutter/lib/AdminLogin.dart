import 'package:flutter/material.dart';
import 'HelperFunctions.dart';

class AdminLogin extends StatefulWidget {
  const AdminLogin({super.key});

  @override
  State<AdminLogin> createState() => _AdminLoginState();
}


class _AdminLoginState extends State<AdminLogin> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Admin Login")),
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
                      padding: const EdgeInsets.fromLTRB(0, 60, 0, 30),
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
