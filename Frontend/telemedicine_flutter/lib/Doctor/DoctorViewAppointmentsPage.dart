import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

class DoctorViewAppointmentsPage extends StatelessWidget {
  const DoctorViewAppointmentsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Appointments")),
      body: ListView(children: [ 

        // TODO retrieve all appointments and list them in rows
        // each row to have manage and cancel
        // appointment details to include here are patient full name, time and date
        // Ordered by date and time!!!

        // Button for making a new appointment
        Padding(
          padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
          child: SizedBox(
            width: screenWidth(context) * 0.15,
            height: 30,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.lightBlue[800],
                textStyle: const TextStyle(
                  fontSize: 12, fontFamily: 'Georgia'
                ),
              ),
              onPressed: () {
                Navigator.push(
                  // TODO enable create abilities
                  context, MaterialPageRoute(builder: (context) => DoctorViewAppointmentsPage()));
              },
              child: const Text("Make a New Appointment")
            ),
          ),
        ),


        // Row for appointment details
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row( 
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
            
              const Padding(
                padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                child: Text("10AM Appointment 01/09/22 w/ Jacob White")
              ),

              // Button for viewing/updating appointment time
              Padding(
                padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
                child: SizedBox(
                  width: screenWidth(context) * 0.15,
                  height: 30,
                  child: ElevatedButton(
                    style: ElevatedButton.styleFrom(
                      primary: Colors.lightBlue[800],
                      textStyle: const TextStyle(
                        fontSize: 12, fontFamily: 'Georgia'
                      ),
                    ),
                    onPressed: () {
                      Navigator.push(
                        // TODO enable edit abilities
                        context, MaterialPageRoute(builder: (context) => DoctorViewAppointmentsPage()));
                    },
                    child: const Text("Manage")
                  ),
                ),
              ),

              // Button for cancelling an appointment
              Padding(
                padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
                child: SizedBox(
                  width: screenWidth(context) * 0.15,
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
                        // TODO add an "Are you sure?" popup
                        context, MaterialPageRoute(builder: (context) => DoctorViewAppointmentsPage()));
                    },
                    child: const Text("Cancel")
                  ),
                ),
              ),

          ]),
        ),

      ]),    
    );
  }
}
