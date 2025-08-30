# Keep all public classes and methods in the vico package
-keep public class com.hussenyehya.vico.** { public *; }

# Keep all annotation classes
-keep class * extends java.lang.annotation.Annotation { *; }

# Keep all data classes
-keepclassmembers class com.hussenyehya.vico.** {
    public <fields>;
    public <methods>;
}

# Keep serialization related classes
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod