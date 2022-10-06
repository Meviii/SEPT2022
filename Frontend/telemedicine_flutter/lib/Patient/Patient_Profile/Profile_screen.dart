import 'package:flutter/material.dart';
import 'MedicalDetails_screen.dart';

class Profile_screen extends StatelessWidget{

  void onPressAppbarCancel() {
    
  }
  
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Profile'),
          leading: IconButton(
              icon: const Icon(Icons.cancel),
              onPressed:() {Navigator.pop(context);} ,
            ),
        ),
        body: ListView(
          children: <Widget>[
            Card(
              child: ListTile(
                title: const Text('Medical Details'),
                onTap: () {
                  Navigator.push(context, MaterialPageRoute(builder: (context) => MedicalDetails_screen()));
                },
              )
            ),
            const Card(
              child: ListTile(
                title: Text('Personal Details'),
                
              )
            ),
            const Card(
              child: ListTile(
                title: Text('My medicine'),
                
              )
            ),
            const Card(
              child: ListTile(
                title: Text('Contact Details'),
                
              )
            ),
            const Card(
              child: ListTile(
                title: Text('Settings'),
                
              )
            ),
            const Card(
              child: ListTile(
                title: Text('Sign Out'),
                
              )
            ),
          ]
        ),
      )  
    );
  }
}


