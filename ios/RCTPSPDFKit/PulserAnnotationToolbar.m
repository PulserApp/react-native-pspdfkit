#import "PulserAnnotationToolbar.h"

@import PSPDFKit;
@import PSPDFKitUI;

@implementation PulserAnnotationToolbar

- (instancetype)initWithAnnotationStateManager:(PSPDFAnnotationStateManager *)annotationStateManager {
  if ((self = [super initWithAnnotationStateManager:annotationStateManager])) {
    NSBundle *bundle = [NSBundle bundleForClass:[self class]];
    UIImage *pinIssueImage = [[UIImage imageNamed:@"pin_pulser_issue" inBundle:bundle compatibleWithTraitCollection:nil] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
    _pinIssueButton = [PSPDFToolbarButton new];
    _pinIssueButton.accessibilityLabel = @"Pin Issue";
    [_pinIssueButton setImage:pinIssueImage];
    _pinIssueButton.imageEdgeInsets = UIEdgeInsetsMake(10, 10, 10, 10);
    [_pinIssueButton addTarget:self action:@selector(pinIssueButtonPressed:) forControlEvents:UIControlEventTouchUpInside];
    self.additionalButtons = @[_pinIssueButton];
  }
  return self;
}

- (void)pinIssueButtonPressed:(id)sender {
}

@end
