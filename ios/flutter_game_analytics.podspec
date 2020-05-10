#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint fluttergameanalytics.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'flutter_game_analytics'
  s.version          = '0.0.1'
  s.summary          = 'A new Flutter plugin for GameAnalytics'
  s.description      = <<-DESC
A new Flutter plugin for GameAnalytics
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.platform = :ios, '8.0'

  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'VALID_ARCHS' => 'armv7 arm64 x86_64' }
  s.swift_version = '5.0'
end
