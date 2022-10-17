import 'package:flutter/material.dart';
import 'Prescription_view_screen.dart';
import 'Prescription_Service.dart';
import 'package:telemedicine_flutter/Model/PrescriptionModel.dart';



class Prescription_list_screen extends StatefulWidget{

  @override
  State<Prescription_list_screen> createState() => Prescription_list_screenState();
}

class Prescription_list_screenState extends State<Prescription_list_screen> {
  
  

  late Future<List<Prescription>?> prescriptions;
  bool isLoaded = false;


  @override
  void initState() {
    super.initState();
    fetchPrescriptions();
    
  }
  /* Gets the list of prescriptions for a user*/
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
          /* ListView.builder creates a card widget for every prescription object in the list 
          which is returned from the backend after the fetchPrescription function call above in the initState function*/  
          return ListView.builder(
            itemCount: snapshot.data!.length,
            itemBuilder: (BuildContext context,int index) {
              String p_name = snapshot.data![index].getId;
              String p_subtitle = snapshot.data![index].getDescription;
              return Card(
                  child: ListTile(
                    title: Text(p_name),
                    subtitle: Text(p_subtitle,overflow: TextOverflow.ellipsis,maxLines: 2),
                    trailing: const Icon(Icons.arrow_right),
                    onTap:() {Navigator.push(context, MaterialPageRoute(
                      /* Sends all the data of the specfic prescription selected by the user to the prescription view screen
                      where the data will be displayed */
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