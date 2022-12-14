import 'package:flutter/material.dart';
import 'HelperFunctions.dart';
import 'Admin/AdminMainPage.dart';

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
        body: ListView(children: [
          Center(
              child: Column(children: [
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
                    child: Column(children: [
                  Padding(
                    padding: const EdgeInsets.fromLTRB(0, 60, 0, 0),
                    child: SizedBox(
                      width: screenWidth(context) * 0.6,
                      child: TextFormField(
                          decoration: const InputDecoration(
                            hintText: 'Username',
                          ),
                          validator: (String? value) {
                            if (value == null || value.isEmpty) {
                              return 'Please enter your username';
                            }
                            return null;
                          }),
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
                            if (value == null || value.isEmpty) {
                              return 'Please enter your password';
                            }
                            return null;
                          }),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(0, 60, 0, 30),
                    child: SizedBox(
                      width: screenWidth(context) * 0.4,
                      height: 50,
                      child: ElevatedButton(
                          onPressed: () {
                            if (_formKey.currentState!.validate()) {
                              // TODO Process data
                            }
                          },
                          child: const Text("Login")),
                    ),
                  ),
                ]))),

            Padding(
              padding: const EdgeInsets.fromLTRB(0, 0, 0, 60),
              child:
                  Row(mainAxisAlignment: MainAxisAlignment.center, children: [
                // Signup new account button
                Padding(
                  padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
                  child: SizedBox(
                    width: screenWidth(context) * 0.3,
                    height: 30,
                    child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          primary: Colors.red[800],
                          textStyle: const TextStyle(
                              fontSize: 12, fontFamily: 'Georgia'),
                        ),
                        onPressed: () {
                          Navigator.push(
                              // TODO link this up to register account page
                              context,
                              MaterialPageRoute(
                                  builder: (context) => AdminLogin()));
                        },
                        child: const Text("Register New Account")),
                  ),
                ),

                // Forgot password button
                Padding(
                  padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
                  child: SizedBox(
                    width: screenWidth(context) * 0.3,
                    height: 30,
                    child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          primary: Color.fromARGB(255, 5, 40, 117),
                          textStyle: const TextStyle(
                              fontSize: 12, fontFamily: 'Georgia'),
                        ),
                        onPressed: () {
                          Navigator.push(
                              // TODO link this up to forgot password page
                              context,
                              MaterialPageRoute(
                                  builder: (context) => AdminMainPage()));
                        },
                        child: const Text("Forgot Password")),
                  ),
                ),
              ]),
            )
          ])),
        ]));
  }
}
