/*
* Author : LiJiqqi
* Date : 2020/7/23
*/
import 'package:flutter/material.dart';
import 'package:flutter_origin_view/complex_page.dart';

class DemoPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return DemoPageState();
  }

}

class DemoPageState extends State<DemoPage> {
  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.lightBlueAccent,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          RaisedButton(
            onPressed: (){
              Navigator.of(context).push(SlideRightRouteBuilder(ComplexPage()));
            },
            child: Text('go complex page'),
          ),
        ],
      ),
    );
  }
}


class SlideRightRouteBuilder extends PageRouteBuilder{
  final Widget page;

  SlideRightRouteBuilder(this.page)
      :super(
    pageBuilder:(ctx,animation,secondaryAnimation) => page,
    opaque:false,
    transitionDuration:Duration(milliseconds: 300),
    transitionsBuilder:(ctx,animation,sAnimation,child)
    => SlideTransition(
      position: Tween<Offset>(
        begin:Offset(1.0,0.0),end: Offset(0.0, 0.0),
      ).animate(CurvedAnimation(parent: animation,curve: Curves.fastOutSlowIn)),
      child: child,
    ),
  );

}
