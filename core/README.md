# Compost Core

## Runtime

* `clippedBackground()` is a `rememberSaveable()` that ready to use with mutable lists. Make sure you understand why
you are using it, cause it's a very specific scenario. In most cases data should be stored at view model.

## Scope Extensions

* `Shading` is useful for Boxes that can be pressed. Instead of standard ripple this one is fade animated.
Multiple shadings can be managed by single bool (for example, to create shading effect on whole complex item card).
* `gridItems` creates grid of elements for LazyColumn. In most cases you should use standard
`LazyVerticalGrid` / `LazyHorizontalGrid` with specified spans. However if you need to place a few grids with columns
GCD equals 1 (2 and 3) at single screen, it would be a problem. This extension is a temporary 
fix.<p>*Originally written at [StackOverflow](https://stackoverflow.com/questions/69336555/fixed-grid-inside-lazycolumn-in-jetpack-compose) by [Phil Dukhov](https://stackoverflow.com/users/3585796/phil-dukhov)

## Modifiers

### Paddings

* `padding()` Flexible wrapper of padding. Use `horizontal`/`vertical` and side paddings together to reduce arguments count.

### Background

* `clippedBackground()` creates clipped background instead of standard `background()` that applies shape only visually.
Suitable for clipping clickable modifier's ripple.

### Clickable

* `simpleClickable()` allows you to set on click action without ripple effect and extra args. Supports debounce
* `scalingClickable()` allows you to change element size on click.
* `debounceClickable()` allows you to set click timeout to prevent extra clicks.

## Shapes

* `DashedLineShape` provides horizontal/vertical dashed line shape for dividers. Supports unequal width and gap.
