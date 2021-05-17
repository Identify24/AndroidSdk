# AndroidSdk

# Gradle
To get a Git project into your build:

Step 1. Add the Gitlab repository to your build file

Add it in your root build.gradle at the end of repositories:

!!! MinSdk version must be at least 21

 <pre>allprojects {
repositories {
...
   maven {
            url 'https://gitlab.com/api/v4/projects/26590072/packages/maven'
            name "GitLab"
            credentials(HttpHeaderCredentials) {
                name = 'Private-Token'
                value = 'EpsJkjBq_gczsMkBQmU9'
            }
            authentication {
                header(HttpHeaderAuthentication)
            }
        }
}
}</pre>


# Usage

Firstly, you have to create options and design for sdk.Later get a singleton object by set the environment variables and options from identify sdk. Then connect to sdk with ID number, thats all.

# For Kotlin
<pre>
     val identityOptions = IdentityOptions.Builder()
                .setIdentityType(listOf(
                        IdentifyModuleTypes.DIJITAL_SIGNATURE,
                        IdentifyModuleTypes.VIDEO_RECORD,
                        IdentifyModuleTypes.TAKE_SELFIE,
                        IdentifyModuleTypes.SPEECH_TEST,
                        IdentifyModuleTypes.IDENTIFICATION_INFORMATION_WITH_CARD_PHOTO,
                        IdentifyModuleTypes.VITALITY_TEST,
                        IdentifyModuleTypes.IDENTIFICATION_INFORMATION_WITH_NFC,
                        IdentifyModuleTypes.AGENT_CALL
                ))
                .setNfcExceptionCount(3) // Default value 3
                .setCallConnectionTimeOut(5000) // Default value 10sn
                .setVideoRecordTime(5000) // Default value 5sn
                .setOpenIntroPage(true) //Default true
                .build()

        val identityDesign = IdentityDesign.Builder()
                .setLogo(R.drawable.identify_icon) //Default identify icon
                .setThemeResourceId(R.style.AppTheme) //Default sdk app theme
                .build()

        val identifyObject = IdentifySdk.Builder()
                .api("api url")
                .socket("socket url","socket port")
                .stun("stun url","stun port")
                .turn("turn url","turn port","turn username","turn password")
.lifeCycle(this.lifecycle)
                .options(identityOptions)
                .design(identityDesign)
                .build()

 identifyObject.startIdentification(this,"xxxx-xxxx-xxxx-xxxx-xxxxxxx","tr")
 
</pre>

# For Java



<pre>
ArrayList<IdentifyModuleTypes> moduleList = new ArrayList<IdentifyModuleTypes>();
        moduleList.add(IdentifyModuleTypes.DIJITAL_SIGNATURE);
        moduleList.add(IdentifyModuleTypes.VIDEO_RECORD);
        moduleList.add(IdentifyModuleTypes.TAKE_SELFIE);
        moduleList.add(IdentifyModuleTypes.SPEECH_TEST);
        moduleList.add(IdentifyModuleTypes.IDENTIFICATION_INFORMATION_WITH_CARD_PHOTO);
        moduleList.add(IdentifyModuleTypes.VITALITY_TEST);
        moduleList.add(IdentifyModuleTypes.IDENTIFICATION_INFORMATION_WITH_NFC);
        moduleList.add(IdentifyModuleTypes.AGENT_CALL);

        IdentityOptions options = new IdentityOptions.Builder()
                .setIdentityType(moduleList)
                .setNfcExceptionCount(5) // Default value 3
                .setCallConnectionTimeOut(5000) // Default value 10sn
                .setVideoRecordTime(5000) // Default value 5sn
                .setOpenIntroPage(true) //Default true
                .build();


        IdentityDesign identityDesign = new IdentityDesign.Builder()
                .setLogo(R.drawable.identify_icon)
                .setThemeResourceId(R.style.AppTheme)
                .build();


        IdentifySdk identifyObject = new IdentifySdk.Builder()
                .api("api url")
                .socket("socket url","socket port")
                .stun("stun url","stun port")
                .turn("turn url","turn port","turn username","turn password")
.lifeCycle(this.getLifecycle())
                .options(options)
                .design(identityDesign)
                .build();

        identifyObject.startIdentification(this,"xxxx-xxxx-xxxx-xxxx-xxxxxxx","language");
 

</pre>

- Identify Options

IdentityType -> Indicates the modules. Modules can be added or removed in any order. Modules should be added to a list.

NfcExceptionCount -> This number specifies the maximum number of errors to be received when reading nfc.This process is passed after the number of errors exceeds this number. This is optional(can be null, default value = 3)

CallConnectionTimeOut -> This number indicates the timeout when connecting to the call. This is optional(can be null, default value = 10000ms)

VideoRecordTime -> This number indicates the duration of the video to be recorded.This is optional(can be null, default value = 5000ms)

OpenIntroPage -> If true, the intro pages of the selected modules are shown. This is optional(can be null, default value = true)

- Identify Design

Logo -> The logo provided will be replaced with the logos in the application design.

ThemeResourceId -> This theme will be replaced by the sdk theme.

Note : If you want to change the design completely, you can manually include SDK in your project. For this you can download the project from github.
Then include sdk in your project with this code -> implementation project(path: ':sdk')



Language is optional(can be null). Default value is English. Supported languages are English, German and Turkish.
* for Turkish language parameter -> tr
* for English language parameter -> en
* for German language parameter -> de


# Listeners

* IdentifyErrorListener -> "xxxx-xxxx-xxxx-xxxx-xxxxxxx" If the ident id is not found
* IdentifyResultListener ->  when processes are over
* SdkLifeCycleListener -> get sdk lifecycle
* IdentifyNavigationListener -> when there are navigation operations


# For Kotlin

<pre>

       identifyObject.identifyErrorListener = object : IdentifyErrorListener{
            override fun identError(errorMessage: String) {
                Toast.makeText(this@MainActivity,errorMessage,Toast.LENGTH_SHORT).show()
            }
        }
       
       
          identifyObject.identifyResultListener = object : IdentifyResultListener {
            override fun nfcProcessFinished(isSuccess: Boolean, mrzDto: MrzDto?) {
                Toast.makeText(this@MainActivity, "nfc process finished", Toast.LENGTH_SHORT).show()
            }

            override fun vitalityDetectionProcessFinished() {
                Toast.makeText(this@MainActivity, "face process finished", Toast.LENGTH_SHORT).show()
            }
            override fun callProcessFinished() {
                Toast.makeText(this@MainActivity, "call process finished", Toast.LENGTH_SHORT).show()
                //  identifyObject.closeSdk() // You can finish sdk with this method when in the process you want
            }

            override fun takeCardPhotoProcessFinished() {
                Toast.makeText(this@MainActivity, "card photo process finished", Toast.LENGTH_SHORT).show()
            }

            override fun takeSelfieProcessFinished() {
                Toast.makeText(this@MainActivity, "selfie process finished", Toast.LENGTH_SHORT).show()
            }

            override fun speechProcessFinished() {
                Toast.makeText(this@MainActivity, "speech process finished", Toast.LENGTH_SHORT).show()
            }

            override fun videoRecordProcessFinished() {
                Toast.makeText(this@MainActivity, "video record process finished", Toast.LENGTH_SHORT).show()
            }

            override fun signatureProcessFinished() {
                Toast.makeText(this@MainActivity, "signature process finished", Toast.LENGTH_SHORT).show()
            }

        }

identifyObject.identifyNavigationListener = object  : IdentifyNavigationListener {
            override fun redirectCallProcess() {
                Toast.makeText(this@MainActivity, "Redirect Call Process", Toast.LENGTH_SHORT).show()
            }

            override fun backPressed(whereFrom: IdentifyModuleTypes) {
                Toast.makeText(this@MainActivity, whereFrom.name + " Back Pressed", Toast.LENGTH_SHORT).show()
            }

        }


        identifyObject.sdkLifeCycleListener = object : SdkLifeCycleListener {
            override fun sdkDestroyed() {
                // Sdk Activity Destroyed
            }

            override fun sdkPaused() {
                // Sdk Activity Paused
            }

            override fun sdkResumed() {
                // Sdk Activity Resumed
            }

        }


</pre>

# For Java

<pre>

        identifyObject.setIdentifyErrorListener(new IdentifyErrorListener() {
            @Override
            public void identError(@NotNull String errorMessage) {
                Toast.makeText(getBaseContext(),errorMessage,Toast.LENGTH_SHORT).show();
            }
        });

        identifyObject.setIdentifyResultListener(new IdentifyResultListener() {
            @Override
            public void signatureProcessFinished() {
                Toast.makeText(getBaseContext(),"signature process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void videoRecordProcessFinished() {
                Toast.makeText(getBaseContext(),"video record process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void speechProcessFinished() {
                Toast.makeText(getBaseContext(),"speech process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void takeSelfieProcessFinished() {
                Toast.makeText(getBaseContext(),"take selfie process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void takeCardPhotoProcessFinished() {
                Toast.makeText(getBaseContext(),"take card photo process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void nfcProcessFinished(boolean isSuccess, @org.jetbrains.annotations.Nullable MrzDto mrzDto) {
                Toast.makeText(getBaseContext(),"nfc process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void vitalityDetectionProcessFinished() {
                Toast.makeText(getBaseContext(),"face process finished",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void callProcessFinished() {
                Toast.makeText(getBaseContext(),"call process finished",Toast.LENGTH_SHORT).show();
               // identifyObject.closeSdk(); -> You can finish sdk with this method when in the process you want
            }
        });


 identifyObject.setIdentifyNavigationListener(new IdentifyNavigationListener() {
            @Override
            public void redirectCallProcess() {
                Toast.makeText(getBaseContext(),"Redirect Call Process",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void backPressed(@NotNull IdentifyModuleTypes whereFrom) {
                Toast.makeText(getBaseContext(),whereFrom.name() + " Back Pressed",Toast.LENGTH_SHORT).show();
            }
        });

        identifyObject.setSdkLifeCycleListener(new SdkLifeCycleListener() {
            @Override
            public void sdkDestroyed() {
                // Sdk Activity Destroyed
            }

            @Override
            public void sdkPaused() {
                // Sdk Activity Paused
            }

            @Override
            public void sdkResumed() {
                // Sdk Activity Resumed
            }
        });

</pre>


# Permission

Permissions used within the sdk (don't need to add, attached in the library)

```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />
    <uses-permission android:name="android.permission.NFC" />
    <uses-permission android:name="android.permission.VIBRATE"/>
    <uses-feature android:name="android.hardware.nfc" />
    <uses-feature android:name="android.hardware.camera" />
```


# LICENSE

Identify Android Sdk Copyright (C) 2020  Identify Turkey

[GNU General Public License v3.0](https://github.com/Identify24/AndroidSdk/blob/main/LICENSE)
