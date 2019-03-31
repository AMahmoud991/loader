# Loader

Loader is a Proof of concept Networking library using RxJava, Di and Kotlin.


## Getting Started

For simple integration all you have to do is to add the following command in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
        maven { url "https://jitpack.io" }
		}
	}
and after this, add the Simple Library Network dependency:

	dependencies {
    implementation 'com.github.AMahmoud991:loader:develop-SNAPSHOT'
	}

### Request Example
 
 RequestCall(Request(method,url, Parser)).getData().subscribeOn(backgroundThreadExecutor.scheduler).flatMap {
            Single.just(it))
}

### Image Example
Load image use LoderImageView Widget

         loaderImageView.loadImage(url);

### Parser
The Lib coming with the Three Out of the Box Parser
1-JsonArray Parser
2-JsonObject Parser
3-Bitmap Parser

you can Add any new New Parser by simplay extend BaseParser Interface

### cache
All Image is Cached in the memory

### History
This library is in someway inspired by https://github.com/AMahmoud991/DeployLibrary
by me also


