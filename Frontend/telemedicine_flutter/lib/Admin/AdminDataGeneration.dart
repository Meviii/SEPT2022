import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

//Class and widget for the DataGeneration button
class DataGeneration extends StatefulWidget {
  const DataGeneration({Key? key}) : super(key: key);

  @override
  State<DataGeneration> createState() => _DataGenerationState();
}

class _DataGenerationState extends State<DataGeneration> {
  TextEditingController textEditingController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.grey,
          title: const Text(
            'Data Generation',
            style: TextStyle(color: Colors.black),
          ),
          centerTitle: true,
          actions: [
            IconButton(
                icon: const Icon(Icons.notifications),
                color: Colors.black,
                onPressed: () {}),
            IconButton(
                icon: const Icon(Icons.question_mark_outlined),
                color: Colors.black,
                onPressed: () {}),
          ],
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(45),
              child: OutlinedButton(
                style: OutlinedButton.styleFrom(
                  minimumSize: const Size(300, 50),
                  maximumSize: const Size(300, 50),
                ),
                child: const Text(
                  "Appointment Data",
                  style: TextStyle(fontSize: 25.0),
                ),
                onPressed: () {},
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(45),
              child: OutlinedButton(
                  style: OutlinedButton.styleFrom(
                    minimumSize: const Size(300, 50),
                    maximumSize: const Size(300, 50),
                  ),
                  child: const Text(
                    "Payment Data",
                    style: TextStyle(fontSize: 25.0),
                  ),
                  onPressed: () => {}),
            ),
            Padding(
              padding: const EdgeInsets.all(45),
              child: OutlinedButton(
                  style: OutlinedButton.styleFrom(
                    minimumSize: const Size(300, 50),
                    maximumSize: const Size(300, 50),
                  ),
                  child: const Text(
                    "Account Data",
                    style: TextStyle(fontSize: 25.0),
                  ),
                  onPressed: () => {}),
            ),
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
        ));
  }
}
