import 'package:flutter/material.dart';
import '../Patient_Profile_Tab/Profile_screen.dart';

class MedicalDetails_screen extends StatefulWidget {
  

  @override
  State<MedicalDetails_screen> createState() => _MedicalDetails_screenState();
}

class _MedicalDetails_screenState extends State<MedicalDetails_screen> {
  
  String? _dropdownValue = 'Nothing';
  int _selectedIndex = 0;
  String textFieldValue = '';
  
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
            title: const Text('Medical Details'),
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
                  SizedBox(height: 20,),

                  Container(
                    
                    margin: const EdgeInsetsDirectional.fromSTEB(40, 40, 40, 70),
                    child: TextField(
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Add Health Information'
                      ),
                      maxLines: 4,
                      maxLength: 124,
                      
                      onChanged: (value) => setState(()=> textFieldValue = value),
                    ),
                    
                  

                  ),
                  

                  ElevatedButton(
                    child: const Text('Save Changes'),
                    onPressed: () {
                      print(_dropdownValue);
                      print(textFieldValue);
                    },
                  )
                ]
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
            ),
          ),
          
      );

    
  }
}