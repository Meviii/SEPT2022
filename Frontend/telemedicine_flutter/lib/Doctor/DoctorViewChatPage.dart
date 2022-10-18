import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

class DoctorViewChatPage extends StatelessWidget {
  const DoctorViewChatPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Chatrooms")),
      body: ListView(children: [ 

        // TODO display existing chats as rows, each row is one chat with one patient
        // button at the bottom (but always on screen - only the chats display should be scrollable) for 'New Chat', which opens a new chat
        // window to select the next patient

        
      ]),    
    );
  }
}
