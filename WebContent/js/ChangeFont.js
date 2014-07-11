YUI().use('slider', 'color', function(Y){	
	
	// initial value of sliders
	text = Y.one('#fontColor');	
	rgb1 = Y.Color.toArray(Y.Color.convert(text.get("value"), Y.Color.TYPES.RGB));
	
    // sliders
	var rSlider = new Y.Slider({ min: 0, max: 255, value: rgb1[0] }),
    gSlider = new Y.Slider({ min: 0, max: 255, value: rgb1[1] }),
    bSlider = new Y.Slider({ min: 0, max: 255, value: rgb1[2] }),

    // color chip
	text = Y.one('#text');
	fontColor = Y.one('#fontColor');

    // render sliders
    rSlider.render('#r-slider');
    gSlider.render('#g-slider');
    bSlider.render('#b-slider');

    // register update events
	rSlider.after('thumbMove', function(e) {    
        updateColors();
	});
    
    gSlider.after('thumbMove', function(e) {    
        updateColors();
    });
    
    bSlider.after('thumbMove', function(e) {    
        updateColors();
    });

    // update the colors strings
    function updateColors() {
        var r = rSlider.get('value'),
            g = gSlider.get('value'),
            b = bSlider.get('value'),
            rgbStr = Y.Color.fromArray([r,g,b], Y.Color.TYPES.RGB);
        rgbStr = Y.Color.toHex(rgbStr);
        text.setStyle('color', rgbStr);
        fontColor.set('value', rgbStr);
    }
            
    rVal.set('text', rSlider.get('value'));
    gVal.set('text', gSlider.get('value'));
    bVal.set('text', bSlider.get('value'));
    updateColors();

});

function setfontFamily(){
	var font = document.getElementById("fontFamily").value;
	var text = document.getElementById("text");
	text.style.fontFamily = font;
}

function selectDropdown(){
	x = document.getElementById(document.getElementById("oldFontFamily").value);	
	x.selected = "selected";	
}