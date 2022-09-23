import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

class DoctorViewProfilePage extends StatelessWidget {
  const DoctorViewProfilePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("My Profile")),
      body: ListView(children: [ 

        // TODO retrieve the following details and list them below
        // (with an edit button next to each)

        // the 'Update' button will open up a textbox input and a update and cancel button below it
        // textbox will contain the existing info of that field as placeholder

        // missing fields will be replaced with N/A



        // Row for Name
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row( 
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
            
              const Padding(
                padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                child: Text("Name: <insert name>")
              ),

              // Button for updating the associated information
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
                        context, MaterialPageRoute(builder: (context) => DoctorViewProfilePage()));
                    },
                    child: const Text("Edit")
                  ),
                ),
              ),
          ]),
        ),

        // Row for Surname
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row( 
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
            
              const Padding(
                padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                child: Text("Surname: <insert surname>")
              ),

              // Button for updating the associated information
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
                        context, MaterialPageRoute(builder: (context) => DoctorViewProfilePage()));
                    },
                    child: const Text("Edit")
                  ),
                ),
              ),
          ]),
        ),


      ]),    
    );
  }
}
