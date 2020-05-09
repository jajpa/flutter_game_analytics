#import "FluttergameanalyticsPlugin.h"
#if __has_include(<fluttergameanalytics/fluttergameanalytics-Swift.h>)
#import <fluttergameanalytics/fluttergameanalytics-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "fluttergameanalytics-Swift.h"
#endif

@implementation FluttergameanalyticsPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFluttergameanalyticsPlugin registerWithRegistrar:registrar];
}
@end
