<img src="https://github.com/AkshayAnil1080/BirthdayWishingApp/blob/main/images/1.jpg" height=900 width=450 /> <img src="https://github.com/AkshayAnil1080/BirthdayWishingApp/blob/main/images/2.jpg" height=900 width=450 />

### 1. Start a new project - a bunch of file will be created.
	Main.activity.kt -  tells how everything will work.	
	activity-main.xml - things( text, button, images...) to be included known as widgets.
 	res
   	|__ drawable -for images
   	|__ layout - activity-main.xml
   	|__ mipmap - launcher icons
   	|__ values 
   	 	|__  for declaration
   	 	|__ colors.xml
   	 	|__ strings.xml - Eg need to convert the text from English to Hindi
   	 	|__ styles.xml  - styling of app
   	|__ Gradle scripts - does multiple test run and convert the program file into apk

### 2. Adding XML layouts
	How to add widgets ?
	Layouts  - constraint Layout
		- guideline
		- Linear Layout
		- Frame Layout
		- Table Layout
		- Table Row
	here, using Constarint Layout for designing and code for it is

      <TextView 
          android:id="@+id/helperMessage"			- Every view has a unique id
          android:layout_width="wrap_content"		- provide the width as the width of text ie to wrap it inside
          android:layout_height="wrap_content"		- provide the height as the height of text ie to wrap it inside
          android:layout_marginTop="60dp"			- using dp for margin is preferable than px as it may differ in high and low intesity pixel devices.
          android:text="@string/enter_the_name"		- here warning will come "extract to strings.xml" , it helps in need to convert the text from one language to another
          app:layout_constraintEnd_toEndOf="parent"	- its end(left) , start(right) , top parent is parent i.e the edge of screen. 
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent" />

      <EditText
          android:id="@+id/nameInput"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="30dp"
          android:ems="10"
          android:inputType="textPersonName"
          android:hint="@string/akshay"
          android:textAlignment="center" 			- to align the text in center
          android:gravity="center_horizontal"		- specifies how an object should position its content on both X and Y axis. Values are top, bottom, left, right, center, center_vertical, center_horizonta
          app:layout_constraintEnd_toEndOf="parent"	- left parent is left edge of screen
          app:layout_constraintStart_toStartOf="parent"	- right parent is right edge of screen
          app:layout_constraintTop_toBottomOf="@+id/helperMessage" - top parent is view present above of it i.e. helperMessage

      <Button
          android:id="@+id/button"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="60dp"
          android:text="@string/create_birthday_card"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          android:textAllCaps="false"			- to make the text appear as actually set for it.
          android:padding="30dp"				- used to create space around an element's content
          app:layout_constraintTop_toBottomOf="@+id/nameInput" />

Useful commands -
Shift+F6  - change the name everywhere in one go.

### 3.
	-> In gradle Scripts - build.grade -under the plugns sectin we need  to add - id 'kotlin-android-extensions' - to sync two pages data 
   
	In button section
	android:onClick="createBirthdayCard" 
	L Alt+Enter - create method in acticvity

	In Main Activity  fun createBirthdayCard(view: View) will be created. complete the operations
	fun createBirthdayCard(view: View) {

        	val name = nameInput.editableText.toString()			    - storing the name using view Id and converting to String

        	Toast.makeText( this, "name is $name" , Toast.LENGTH_LONG).show()   - to make text appear on screen for seconds based on user actions, passing the name here
    	}
	}	

### 4: Jump from one screen to another 
	1.
	Using intent constructor(to move from one process to another) - two paremeters are passed, current activity and the activity to be opened.
	Eg. clicking on link opens the youtube, sharing via whatsapp..
	Also, we can pass data in the intent (key, value pair)

  	fun createBirthdayCard(view: View) {

 		val name = nameInput.editableText.toString()				// storing the name
        	val intent  = Intent(this, BirthdayGreetActivity::class.java)		// make intent
		intent.putExtra("name", name)						// passing the name via intent
        	startActivity(intent)							// start the activity
    	}
	2. Go to activity_birthday_greet.xml - Make a text view design and set the id - birhtdayGreet 
	3. Receiving the data from current activity. OPEN BirhtdayGreetActivity.kt
		companion object  // making a static variable can be used at different locations //2
    		{
        	const val NAME_EXTRA = "name_extra"  // const => cannot be changed now
    		}	

    		val name =  intent.getStringExtra(NAME_EXTRA) // 1. "name is the key passed in intent.putExtra
    		birthdayGreeting.text = "Happy birthday $name"  //3 .made a text view in design and use its id to display the text. here, birthdayGreeting is the text view id of BirhtdayGreetActivit activity


	sp for text size and dp for everything else
	sp = scale independent pixel
	dp = density independent pixels

### 4. Add images in drawable folder - adding image view in activity_birthday_greet.xml
	 	<ImageView
        	android:layout_width="match_parent"
        	android:layout_height="match_parent"
        	android:src="@drawable/cake"
        	android:scaleType="centerCrop"/>

### 5. Some properties in  text view 
		android:textSize="48sp"						- text size
        	android:fontFamily="cursive"	-				- text style
        	android:textColor="@color/design_default_color_primary"		- text color
        	android:textStyle="bold"					- text bold
		android:textAlignment="center"					- text alignment
        	android:gravity="center_horizontal" />				- need to add the gravity for text alignment

### 6. adding image view in mainActivity.xml 
		<ImageView
        	android:layout_width="match_parent"	- width till edge of screen
       		android:layout_height="match_parent"	
       		android:src="@drawable/cake1"		- location of image
        	android:scaleType="centerCrop"/>	- zoom out the image from center to fil in screen if image size is small than sccreen size
 
