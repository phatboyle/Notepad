/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.demo.notepad1;

<<<<<<< HEAD
//import com.android.demo.notepad1.R;
=======
// practice working on a branch and then pushing it, then merging it in to master
// create a branch
// make some changes
// merge to master

// then do the same but push branch to the remote

// practice making a change and pushing and merging if in another repo



import android.R;
>>>>>>> ba63b8cef521c43ea170edc8c165d657132ac8c3
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;

public class Notepadv1 extends ListActivity {
    private int mNoteNumber = 1;
    private NotesDbAdapter mDbHelper;
    public static final int INSERT_ID = Menu.FIRST;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_list);
        mDbHelper=new NotesDbAdapter(this);
        mDbHelper.open();
        fillData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, INSERT_ID, 0, R.string.menu_insert);
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case INSERT_ID:
    		createNote();
    		return true;
    	}
        // TODO Auto-generated method stub
        return super.onOptionsItemSelected(item);
    }
    private void createNote(){
    	String noteName = "Note " + mNoteNumber++;
    	mDbHelper.createNote(noteName, "");
    	fillData();
    	
    }
    private void fillData(){
    	// Get all of the notes fro mthe database and create
    	Cursor c = mDbHelper.fetchAllNotes();
    	startManagingCursor(c);
    	String[] from= new String[] {NotesDbAdapter.KEY_TITLE};
    	int[] to = new int[] {R.id.text1};
    	
    	// Now create an array adapter and set it to display using our row
    	SimpleCursorAdapter notes = new SimpleCursorAdapter(this, R.layout.notepad_list, c, from, to);
    	setListAdapter(notes);
    	
    }
    
}
