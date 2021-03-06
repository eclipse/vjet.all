/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
vjo.ctype("org.eclipse.vjet.dsf.jst.validation.vjo.rt.array.ArrayTest")
.protos({

    //> public int someMethod()
    someMethod:function(){
        return 5;
    },
    
    //> public void accessArrayElement()
    accessArrayElement1:function(){
        var myArray = [ 3, 'hello!',this.someMethod(),{'color':'blue', 'budget':25}];
    },
    
     //> public void accessArrayElement2()
    accessArrayElement2:function(){
        var monthArray = new Array(4); //< String[]
        monthArray[0] = "Jan";
        monthArray[1] = "Feb";
        monthArray[3] = "April";
        var override_monthArrayItem = "test"; //< String
        override_monthArrayItem = monthArray[2];
        
        var myCars = new Array(3); //< String[]
        myCars[0] = "Saab";
        myCars[1] = "Volvo";
        myCars[2] = "BMW";
       
        var myCarsStr = new Array("Saab","Volvo","BMW"); //< String[]
        myCars[0] = myCarsStr[4];
        
        var myInt = new Array(1,2,3); //< String[]
        myCars[1] = myInt[1];
           
        var myArray = [ 'zero', 'one', 'two', 'three', 'four', 'five' ]; //< String[]
        myCarsStr[2] = myArray[4];
         
        //Associative Array
        var associativeArray = [];  //< String[]
		associativeArray["one"] = "First";
		associativeArray["two"] = "Second";
		associativeArray["three"] = "Third";
    },
    
    //> public void multiDimentionalArray()
    multiDimentionalArray:function(){
        var x = [0,1,2,3,4,5];  //< int[]
        var y = [x];
        y[0][1];
        y[1][0];
        
        var multiArr1 = new Array();
        for(var i = 0; i < 4; i++)
 	       multiArr1[i] = new Array(3);
 	    multiArr1[1][1];
 	    multiArr1[4][4];
         
        var multiArr2 = new Array(); //< String[][]
        multiArr2=
	    [
	     new Array( "Venus" , "Mars" , "Earth" ) ,
		 new Array( "Virgo" , "Leo" , "Galaxy" ) ,
		 new Array( "Eve" , "Adam" , "Paradise" )
		];
		
		var strRef = multiArr2[0][0];//<String
		strRef = multiArr2[4][4];
    }
})
.endType();