import 'package:flutter/material.dart';
import 'SecondPage.dart';
import 'Patient/Patient_Profile/Profile_screen.dart';

const Color darkBlue = Color.fromARGB(255, 18, 32, 47);

void main() {
  runApp(MyApp());
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
      appBar: AppBar(title: const Text('MAIN')),
      body: Row(children: [
        ElevatedButton(
            child: const Text('Admin'),
            onPressed: () => print('Admin button pressed')),
        ElevatedButton(
          child: const Text('Doctor'),
          onPressed: () {
            Navigator.push(
                context, MaterialPageRoute(builder: (context) => SecondPage()));
          },
        ),
        ElevatedButton(
            child: const Text('Patient'),
            onPressed: () {
              Navigator.push(context, MaterialPageRoute(builder: (context)=>Profile_screen()));
            }
      ]),
    ));
  }
}
