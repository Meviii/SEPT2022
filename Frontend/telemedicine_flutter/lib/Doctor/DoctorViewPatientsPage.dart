import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

class DoctorViewPatientsPage extends StatelessWidget {
  const DoctorViewPatientsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Patients")),
      body: ListView(children: [ 


        // TODO View a list of all patients here

        //foreach (Patient p in Patients) {
        //
        // The padding thing below
        //
        //}

        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row( 
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
            
              // Container holding patient name and ID
              // TODO fix left align
              Padding(
                padding: const EdgeInsets.fromLTRB(20, 0, 0, 0),
                child: Column( children: [
                  const Align(
                    alignment: Alignment.centerLeft,
                    child: Text("Patient Full Name")
                  ),
                  const Align(
                    alignment: Alignment.centerLeft,
                    child: Text("Patient ID")
                  ),
                ]),
              ),
              
              
              // Button for managing the selected patient
              Row(
                children: [
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
                            // TODO link this up to register account page
                            context, MaterialPageRoute(builder: (context) => DoctorViewPatientsPage()));
                        },
                        child: const Text("Manage")
                      ),
                    ),
                  ),
                

                //Button for removing the selected patient
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
                          // TODO link this up to register account page
                          context, MaterialPageRoute(builder: (context) => DoctorViewPatientsPage()));
                      },
                      child: const Text("Remove")
                    ),
                  ),
                ),
              ]),

          ]),
        ),

      ]),
        


        // Each patient is a row with two buttons : Manage, Remove

        // Remove should clear that patient from the doctor's list

        // Manage goes to the patient profile
        // Patient profile page can then be navigated from a bottom bar for profile, prescriptions, appointments
        // Remove the appbar's 'back button' and replace it with an X that returns to the view patients page
        
        
    
    );
  }
}
