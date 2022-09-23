import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

class DoctorViewAvailabilitiesPage extends StatelessWidget {
  const DoctorViewAvailabilitiesPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Availabilities")),
      body: ListView(children: [ 

        // TODO replace list view body with a container covering width of the screen

        // container will hold calendar with multiple rows (each following the same style of calendar weeks)
        // each row has boxes for each day
        // clicking on a day will open a popup where the doctor can set as available (green) or unavailable (pink)

        
      ]),    
    );
  }
}
