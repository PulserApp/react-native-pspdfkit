#import "PulserAnnotationToolbar.h"

@import PSPDFKit;
@import PSPDFKitUI;

@implementation PulserAnnotationToolbar

- (instancetype)initWithAnnotationStateManager:(PSPDFAnnotationStateManager *)annotationStateManager {
  if ((self = [super initWithAnnotationStateManager:annotationStateManager])) {
    // Remove "Note", "Image", "Sound" and "Stamp" buttons from annotation toolbar
    NSMutableSet *editableTypes = [self.editableAnnotationTypes mutableCopy];
    [editableTypes removeObject:PSPDFAnnotationStringNote];
    [editableTypes removeObject:PSPDFAnnotationStringImage];
    [editableTypes removeObject:PSPDFAnnotationStringStamp];
    [editableTypes removeObject:PSPDFAnnotationStringSound];
    [editableTypes removeObject:PSPDFAnnotationStringSavedAnnotations];
    self.editableAnnotationTypes = editableTypes;
    
    NSBundle *bundle = [NSBundle bundleForClass:[self class]];
    UIImage *pinIssueImage = [[UIImage imageNamed:@"pin_pulser_issue" inBundle:bundle compatibleWithTraitCollection:nil] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
    
    _pinIssueButton = [PSPDFToolbarButton new];
    _pinIssueButton.accessibilityLabel = @"Pin Issue";
    [_pinIssueButton setImage:pinIssueImage];
    _pinIssueButton.imageEdgeInsets = UIEdgeInsetsMake(10, 10, 10, 10);
    
    self.additionalButtons = @[_pinIssueButton];
  }
  return self;
}

@end
