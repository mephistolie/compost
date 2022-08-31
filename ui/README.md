# Compost UI

## Views

### Text Fields

* `TextField` is an analogue of standard TextField with more freedom. Instead of original it has modifiable paddings and doesn't apply background, minimum size and indicator line modifiers. You can add them by pass suitable modifier by default. Also singleLine argument reduced to maxLines.
* `IndicatorLineTextField` is an `TextField` with customizable indicator line. It also hasn't horizontal paddings by default, so text will be printed exactly from the beginning of the line.

### Buttons

* `CircleIconButton` is a round button with icon.
* `CircleImageButton` is a round button with image. Useful when need to use a multicolor image. In other cases use function above.
* `TextButton` is a button with text inside.
* `ProgressButton` is a button with loading animation support and customizable progress indicator.

### Checkboxes

* `Checkbox` is an animated analogue of standard Checkbox with customizable shape.
* `CircleCheckbox` is an `Checkbox` implementation with circle shape.
* `RectangleCheckbox` is an `Checkbox` implementation with rectangle shape. Supports corner radius.

### Radio Buttons
* `RadioButton` is a customizable animated analogue of standard RadioButton.
* `OutlineRadioButton` is an RadioButton with animated stroke instead of dot.
