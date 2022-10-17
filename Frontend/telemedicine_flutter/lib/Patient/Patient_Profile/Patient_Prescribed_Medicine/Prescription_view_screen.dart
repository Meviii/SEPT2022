import 'package:flutter/material.dart';
import 'package:telemedicine_flutter/Model/MedicineModel.dart';



class Prescription_view_screen extends StatelessWidget {

  String Doctor_name='';
  String Patient_name='';
  String Prescription_info='';
  List<Medicine>? medicine;

  Prescription_view_screen({
    Key? key,
    required this.Doctor_name,
    required this.Patient_name,
    required this.Prescription_info,
    this.medicine
  }) : super(key:key);


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('My Medicine'),
          leading: IconButton(
              icon: const Icon(Icons.cancel),
              onPressed:() {Navigator.pop(context);} ,
            ),
        ),
        body: ListView(
          children: [
            Column(
              children: [
                Center(
                  child: Card(
                    color: Color.fromARGB(255, 255, 255, 255),
                    child: SizedBox(
                      height: 100,
                      width: 300,
                      child:Center(child: Text("Doctor id: "+Doctor_name))),
                  ),
                ),
                Center(
                  child: Card(
                    color: Color.fromARGB(255, 255, 255, 255),
                    child: SizedBox(
                      height: 100,
                      width: 300,
                      child:Center(child: Text("Patient id: "+Patient_name))),
                  ),
                ),
                const SizedBox(
                    
                    child:Text("Prescription Information")
                ),
                Center(
                  child: Card(
                    color: Color.fromARGB(255, 255, 255, 255),
                    child: SizedBox(
                      height: 200,
                      width: 450,
                      child:Text(Prescription_info)),
                  ),
                ),
                const SizedBox(
                    
                    child:Text("Medicine List")
                ),
                Center(
                  child: DataTable(
                    columns: const [
                      DataColumn(label: Text("id")),
                      DataColumn(label: Text("Name")),
                      DataColumn(label: Text("Description")),
                      DataColumn(label: Text("Dosage")),
                    ],
                    rows: medicine!.map<DataRow>((e) => DataRow(cells: [
                      DataCell(Text(e.id)),
                      DataCell(Text(e.name)),
                      DataCell(Text(e.description)),
                      DataCell(Text(e.dosage)),
                    ])).toList(),
                  )
                )
              ],
            )
          ],
        ),
        
        
        bottomNavigationBar: BottomNavigationBar(
          type: BottomNavigationBarType.fixed,
          items: const [
            BottomNavigationBarItem(
              icon: Icon(
                Icons.home,
                color: Colors.black,
              ),
              label: 'Home',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.person,
                color: Colors.black,
              ),
              label: 'Profile',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.chat,
                color: Colors.black,
              ),
              label: 'Chat',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.more,
                color: Colors.black,
              ),
              label: 'More',
            ),
          ],
        )
      )
    );
  }
}