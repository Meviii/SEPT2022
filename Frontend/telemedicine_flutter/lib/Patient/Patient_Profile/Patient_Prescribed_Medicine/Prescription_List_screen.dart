import 'package:flutter/material.dart';
import 'Prescription_view_screen.dart';
import 'Prescription_Service.dart';
import 'package:telemedicine_flutter/Model/PrescriptionModel.dart';

// class Prescription {
//   String Prescription_name;
//   String Prescription_subtitle;
//   String Doctor_name;
//   String Patient_name;
//   String Prescription_info;

//   Prescription({
//     required this.Doctor_name,
//     required this.Patient_name,
//     required this.Prescription_info,
//     required this.Prescription_name,
//     required this.Prescription_subtitle,
//   });
  
  

//   String getPrecriptionName(){
//     return Prescription_name;
//   }

//   String getPrecriptionSubtitle(){
//     return Prescription_subtitle;
//   }

//   String getDotorName(){
//     return Doctor_name;
//   }

//   String getPatientName(){
//     return Patient_name;
//   }

//   String getPrecriptionInfo(){
//     return Prescription_info;
//   }
  
// }

class Prescription_list_screen extends StatefulWidget{

  @override
  State<Prescription_list_screen> createState() => Prescription_list_screenState();
}

class Prescription_list_screenState extends State<Prescription_list_screen> {
  
  // Prescription p1 = Prescription(
  //   Prescription_name: 'Prescription Name 1', 
  //   Prescription_subtitle: 'Prescription subtitle 1',
  //   Doctor_name: 'Doctor_name 1',
  //   Patient_name: 'Patient_Name 1', 
  //   Prescription_info: 'Prescription_Info 1' );

  

  // Prescription p2 =  Prescription(
  //   Prescription_name: 'Prescription Name 2', 
  //   Prescription_subtitle: 'Prescription subtitle 2',
  //   Doctor_name: 'Doctor_name 2',
  //   Patient_name: 'Patient_Name 2', 
  //   Prescription_info: 'Prescription_Info 2'  );

  // Prescription p3 =  Prescription(
  //   Prescription_name: 'Prescription Name 3 ', 
  //   Prescription_subtitle: 'Prescription subtitle 3aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
  //   Doctor_name: 'Doctor_name 3',
  //   Patient_name: 'Patient_Name 3', 
  //   Prescription_info: 'Prescription_Info 3' );

  late Future<List<Prescription>?> prescriptions;
  bool isLoaded = false;


  @override
  void initState() {
    // TODO: implement initState
    //medicine_list.addAll({p1,p2,p3});
    super.initState();
    fetchPrescriptions();
    
  }
  
  fetchPrescriptions() async{
    prescriptions = PrescriptionService().getPrescription(); 
    setState(() {
      isLoaded = true;
    });
  }


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
        body:  FutureBuilder<List<Prescription>?>(
          future: prescriptions,
          builder: (context, snapshot) {
          if(snapshot.hasData) {
          return ListView.builder(
            itemCount: snapshot.data!.length,
            itemBuilder: (BuildContext context,int index) {
              
              
              String p_name = snapshot.data![index].getId;
              
              String p_subtitle = snapshot.data![index].getDescription;
              return 
              Card(
                  child: ListTile(
                    title: Text(p_name),
                    subtitle: Text(p_subtitle,overflow: TextOverflow.ellipsis,maxLines: 2),
                    trailing: const Icon(Icons.arrow_right),
                    onTap:() {Navigator.push(context, MaterialPageRoute(
                      builder: (context) => Prescription_view_screen(
                        Doctor_name: snapshot.data![index].getDoctorId, 
                        Patient_name: snapshot.data![index].getPatientId,
                        Prescription_info: snapshot.data![index].getDescription,
                        medicine: snapshot.data![index].getMedicines,)
                      ));} 
                  ),
                  )
            ;}
          );
          
          }else if(snapshot.hasError) {
            return Text('${snapshot.error}');
          }return const Center(child: CircularProgressIndicator()) ;},
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