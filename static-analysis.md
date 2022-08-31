
## Metrics

* 32 number of properties

* 11 number of functions

* 0 number of classes

* 5 number of packages

* 12 number of kt files

## Complexity Report

* 1,039 lines of code (loc)

* 713 source lines of code (sloc)

* 434 logical lines of code (lloc)

* 269 comment lines of code (cloc)

* 23 cyclomatic complexity (mcc)

* 17 cognitive complexity

* 3 number of total code smells

* 37% comment source ratio

* 52 mcc per 1,000 lloc

* 6 code smells per 1,000 lloc

## Findings (3)

### comments, OutdatedDocumentation (1)

KDoc comments should match the actual function or class signature

[Documentation](https://detekt.dev/docs/rules/comments#outdateddocumentation)

* /Users/mephistolie/Development/Personal/Projects/compost/ui/src/main/kotlin/com/mephistolie/compost/ui/buttons/TextButton.kt:62:5
```
Documentation of TextButton is outdated
```
```kotlin
59  * @param textStyle Style configuration for the text such as color, font, line height etc.
60  */
61 @Composable
62 fun TextButton(
!!     ^ error
63     text: String,
64     onClick: () -> Unit,
65     modifier: Modifier = Modifier,

```

### naming, FunctionParameterNaming (1)

Function parameter names should follow the naming convention set in the projects configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionparameternaming)

* /Users/mephistolie/Development/Personal/Projects/compost/ui/src/main/kotlin/com/mephistolie/compost/ui/buttons/TextButton.kt:76:5
```
Function parameter names should match the pattern: [a-z][A-Za-z0-9]*
```
```kotlin
73     contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
74     fontSize: TextUnit = TextUnit.Unspecified,
75     fontStyle: FontStyle? = null,
76     fontвWeight: FontWeight? = null,
!!     ^ error
77     fontFamily: FontFamily? = null,
78     letterSpacing: TextUnit = TextUnit.Unspecified,
79     textDecoration: TextDecoration? = null,

```

### style, UnusedPrivateMember (1)

Private member is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivatemember)

* /Users/mephistolie/Development/Personal/Projects/compost/ui/src/main/kotlin/com/mephistolie/compost/ui/buttons/TextButton.kt:76:5
```
Function parameter `fontвWeight` is unused.
```
```kotlin
73     contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
74     fontSize: TextUnit = TextUnit.Unspecified,
75     fontStyle: FontStyle? = null,
76     fontвWeight: FontWeight? = null,
!!     ^ error
77     fontFamily: FontFamily? = null,
78     letterSpacing: TextUnit = TextUnit.Unspecified,
79     textDecoration: TextDecoration? = null,

```

generated with [detekt version 1.21.0](https://detekt.dev/) on 2022-08-31 21:00:05 UTC
