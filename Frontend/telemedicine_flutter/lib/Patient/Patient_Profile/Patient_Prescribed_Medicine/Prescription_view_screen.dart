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
    List<int> card_colour = [255,255,255,255];
    List<double> user_info_card_hw = [100,300];
    List<double> info_card_hw = [200,450];

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
                  // This is the card that shows all the doctor information which gave this preescription
                  child: Card(
                    color: Color.fromARGB(card_colour[0],card_colour[1],card_colour[2],card_colour[3]),
                    child: SizedBox(
                      height: user_info_card_hw[0],
                      width: user_info_card_hw[1],
                      child:Center(child: Text("Doctor id: "+Doctor_name))),
                  ),
                ),
                Center(
                  // This card shows the patients information for which the prescription was assigned to
                  child: Card(
                    color: Color.fromARGB(card_colour[0],card_colour[1],card_colour[2],card_colour[3]),
                    child: SizedBox(
                      height: user_info_card_hw[0],
                      width: user_info_card_hw[1],
                      child:Center(child: Text("Patient id: "+Patient_name))),
                  ),
                ),
                const SizedBox(  
                  child:Text("Prescription Information")
                ),
                Center(
                  // This card shows the specific prescriptions description which would have 
                  // been written by the doctor who assigned the prescription
                  child: Card(
                    color: Color.fromARGB(card_colour[0],card_colour[1],card_colour[2],card_colour[3]),
                    child: SizedBox(
                      height: info_card_hw[0],
                      width: info_card_hw[1],
                      child:Text(Prescription_info)),
                  ),
                ),
                const SizedBox(
                    
                    child:Text("Medicine List")
                ),
                Center(
                  // Show the list of medicine assigned to a specific prescription 
                  // in a table format with columns id, medicine name,medicine description, dosage
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