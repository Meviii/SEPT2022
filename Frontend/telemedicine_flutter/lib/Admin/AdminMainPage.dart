import 'package:flutter/material.dart';
import '../HelperFunctions.dart';
import 'AdminAccountManagement.dart';
import 'AdminAccountCreation.dart';
import 'AdminDataGeneration.dart';

void main() {
  runApp(const AdminMainPage());
}

class AdminMainPage extends StatefulWidget {
  const AdminMainPage({Key? key}) : super(key: key);

  @override
  State<AdminMainPage> createState() => _AdminMainPageState();
}

//Title and header for the main page
class _AdminMainPageState extends State<AdminMainPage> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: Scaffold(
            appBar: AppBar(
              title: const Text(
                'Admin Panel',
                style: TextStyle(color: Colors.black),
              ),
              centerTitle: true,
              backgroundColor: Colors.white,
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
            //Using FirstScreen method to load the main page which is on a
            //different widget and adding navigation bar
            body: const FirstScreen(),
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
            )));
  }
}

//FirstScreen class and widget for the main page for the admin
class FirstScreen extends StatelessWidget {
  const FirstScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
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
              "Account Management",
              style: TextStyle(fontSize: 25.0),
            ),
            onPressed: () => Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => const AccountManagement())),
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
              "Account Creation",
              style: TextStyle(fontSize: 25.0),
            ),
            onPressed: () => Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => const AccountCreation())),
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
              "Data Generation",
              style: TextStyle(fontSize: 25.0),
            ),
            onPressed: () => Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => const DataGeneration())),
          ),
        ),
      ],
    );
  }
}
