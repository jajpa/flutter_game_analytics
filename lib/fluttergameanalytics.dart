import 'dart:async';

import 'package:flutter/services.dart';

class FlutterGameAnalytics {
  static const MethodChannel _channel =
      const MethodChannel('fluttergameanalytics');

  static Future initialize(String gameKey, String secretKey) async {
    assert(gameKey != null && secretKey != null);
    return await _channel.invokeMethod(
      'initialize',
      {'game_key': gameKey, 'secret_key': secretKey},
    );
  }
}
