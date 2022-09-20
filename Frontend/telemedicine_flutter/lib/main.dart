import 'package:flutter/material.dart';
import 'HomePage.dart';


const Color darkBlue = Color.fromARGB(255, 18, 32, 47);


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData (

        // Define brightness and colours of the theme
        brightness: Brightness.dark,
        primaryColor: Colors.red,

        // Define font styling
        fontFamily: 'Georgia',

        // Define button themes
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
            primary: Colors.lime[800],
            textStyle: const TextStyle(
              fontSize: 16, fontFamily: 'Georgia'
            ),
          )
        ),
      ),
      debugShowCheckedModeBanner: false,
      home: const Scaffold(
        body: Center(
          child: HomePage(),
        ),
      ),
    );
  }
}

