import 'package:flutter/material.dart';

const Color darkBlue = Color.fromARGB(255, 18, 32, 47);

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData.dark().copyWith(
        scaffoldBackgroundColor: darkBlue,
      ),
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: Center(
          child: MyWidget(),
        ),
      ),
    );
  }
}

class MyWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('MAIN')
        ),
        
        body: Row(
          children: [
            
            ElevatedButton(
              child: const Text('Admin'),
              onPressed: ()=>print('Admin button pressed')
            ),
            ElevatedButton(
              child: const Text('Doctor'),
              onPressed: ()=>print('Doctor button pressed')
            ),
            ElevatedButton(
              child: const Text('Patient'),
              onPressed: ()=>print('Patient button pressed')
            ),
          ]
        ),
      )
    );
  }
}
