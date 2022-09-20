import 'package:flutter/material.dart';
import 'Profile_screen.dart';

class MedicalDetails_screen extends StatefulWidget {
  

  @override
  State<MedicalDetails_screen> createState() => _MedicalDetails_screenState();
}

class _MedicalDetails_screenState extends State<MedicalDetails_screen> {
  
  String? _dropdownValue = 'Nothing';
  int _selectedIndex = 0;
  
  void dropdownCallback(String? selectedValue){
    if (selectedValue is String){
      setState(() {
        _dropdownValue = selectedValue;
      });
    }
  }

  void onItemTap(int selectedIndex){
    setState(() {
        _selectedIndex = selectedIndex;
      });
  }

  void onPressAppbarCancel(){
    Navigator.pop(context);
  }

  void onPressAppbarNotification(){

  }
  
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
            backgroundColor: Colors.red,
            title: const Text('Menu bar for md online'),
            actions: [
              IconButton(
                icon: const Icon(Icons.notifications_none),
                onPressed: onPressAppbarNotification,
              ),
            ],
            leading: IconButton(
              icon: const Icon(Icons.cancel),
              onPressed: onPressAppbarCancel,
            ),
        ),
        body: Column(
                
                children: [
                  const Center(
                    child: Text('Medical Details',textScaleFactor: 2.5),
                    
                  ),
                  Container(
                    margin: const EdgeInsetsDirectional.fromSTEB(0, 50, 0, 0),
                    child: const Text('Health Status',textScaleFactor: 1.8),
                    
                  ),
                  
                  Container(
                    margin: const EdgeInsetsDirectional.fromSTEB(40, 40, 40, 0),
                    child: DropdownButton(
                          items: const [
                            DropdownMenuItem(child:Text('Nothing'),value:'Nothing'),
                            DropdownMenuItem(child:Text('Fever'),value:'Fever'),
                            DropdownMenuItem(child:Text('Flu'),value:'Flu'),
                            DropdownMenuItem(child:Text('Covid'),value:'Covid')
                          ],
                          value: _dropdownValue,
                          onChanged: dropdownCallback,
                          isExpanded: true,
                      )
                        
                    ),
                  
                  Container(
                    margin: const EdgeInsetsDirectional.fromSTEB(0, 50, 0, 0),
                    child: const Text('Health Information',textScaleFactor: 1.8),
                    
                    ),
                  
                  Container(
                    margin: const EdgeInsetsDirectional.fromSTEB(40, 40, 40, 70),
                    child: const TextField(
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Add Health Information'
                      ),
                      maxLines: 4,
                      maxLength: 124,
                    ),
                    
                  ),
                  
                ]
              ),
                bottomNavigationBar: BottomNavigationBar(
                  items: const <BottomNavigationBarItem>[
                    BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Home'),
                    BottomNavigationBarItem(icon: Icon(Icons.chat_bubble), label: 'Chat'),
                    BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Settings'),
                  ],
                  currentIndex: _selectedIndex,
                  selectedItemColor: Colors.red,
                  onTap: onItemTap,
                ),
          ),
          
      );

    
  }
}