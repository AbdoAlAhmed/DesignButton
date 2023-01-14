# DesignButton
DesignButton with canvas


## video


https://user-images.githubusercontent.com/114856959/212492365-46126d90-1150-40e5-9144-73a6caea14be.mp4




### to install the lib 


Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
```

Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.AbdoAlAhmed:DesignButton:1.1'
	}
 
``` 



step 3. add in layout and make your changes

```
 <com.abdoalahmed.designbutton.DesignButton
            android:id="@+id/designButton"
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_margin="10dp"
            android:padding="20dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:background_color="@color/teal_200"
            app:background_progress_color="@color/teal_700"
            app:circle_color="@color/green"
            app:circle_progress_color="@color/red"
            app:text_color="@color/black"
	    app:text="Click"
            app:progress="0"
            />
	   
```
Don't forget to change the color and the text

```
            app:background_color="@color/teal_200"
            app:background_progress_color="@color/teal_700"
            app:circle_color="@color/green"
            app:circle_progress_color="@color/red"
            app:text_color="@color/black"
	    app:text="Click"
```


