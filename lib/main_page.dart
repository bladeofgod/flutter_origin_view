


import 'package:flutter/material.dart';
import 'package:flutter_origin_view/demo_page.dart';
import 'package:flutter_origin_view/web_view.dart';
import 'package:flutter_origin_view/web_view_c.dart';

class MainPage extends StatefulWidget {
  @override
  _MainPageState createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Material(
      child: Container(
        width: size.width,height: size.height,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              onPressed: (){
                Navigator.of(context).push(new MaterialPageRoute(builder: (ctx)=>DemoPage()));
              },
              child: Text('to demo page'),
            ),
            RaisedButton(
              onPressed: (){
                Navigator.of(context).push(new MaterialPageRoute(builder: (ctx)=>WebViewG()));
              },
              child: Text('to web page g'),
            ),
            RaisedButton(
              onPressed: (){
                Navigator.of(context).push(new MaterialPageRoute(builder: (ctx)=>WebViewC()));
              },
              child: Text('to web page c'),
            ),
          ],
        ),
      ),
    );
  }



}


















