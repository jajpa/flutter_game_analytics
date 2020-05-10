#import "FluttergameanalyticsPlugin.h"
#import <flutter_game_analytics/flutter_game_analytics-Swift.h>

@implementation FluttergameanalyticsPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFluttergameanalyticsPlugin registerWithRegistrar:registrar];
}
@end
