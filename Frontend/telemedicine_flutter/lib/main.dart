import 'package:flutter/material.dart';
import 'SecondPage.dart';
import 'Patient/Patient_Profile/Profile_screen.dart';

const Color darkBlue = Color.fromARGB(255, 18, 32, 47);

double screenWidth(BuildContext context) {
  return MediaQuery.of(context).size.width;
}

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData.dark().copyWith(
        scaffoldBackgroundColor: darkBlue,
      ),
      debugShowCheckedModeBanner: false,
      home: const Scaffold(
        body: Center(
          child: MyWidget(),
        ),
      ),
    );
  }
}

class MyWidget extends StatelessWidget {
  const MyWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(centerTitle: true, title: const Text('ND Telemedicine')),
        body: Center( 
          // TODO : add child for brand image here

          // Column for the navigation buttons
          child: Column(children: [
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 30),
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
              padding: const EdgeInsets.symmetric(vertical: 30),
              child: SizedBox(
                width: screenWidth(context) * 0.4,
                height: 50,
                child: ElevatedButton(
                  child: const Text('Doctor'),
                  onPressed: () {
                    Navigator.push(
                      context, MaterialPageRoute(builder: (context) => SecondPage()));
                  },
                ),
              ),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 30),
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
        )
      )
    );
  }
}
