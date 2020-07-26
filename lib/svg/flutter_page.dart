import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class FlutterPage extends StatefulWidget {
  @override
  _FlutterPageState createState() => _FlutterPageState();
}

class _FlutterPageState extends State<FlutterPage> {

  final String assetName = 'assets/blend_mode_devil.svg';

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Material(
      child: Container(
        width: size.width,height: size.height,
        child: ListView(
          children: List.generate(30, (index){
            return Container(
              width: 200,height: 200,
              child: SvgPicture.asset(assetName),
            );
          }),
        ),
      ),
    );
  }
}
