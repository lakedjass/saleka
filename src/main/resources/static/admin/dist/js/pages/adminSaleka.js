(function() {
    const photo = document.querySelector("#userProfilePhoto")
    let photoDialog = document.querySelector("#userProfileBloc")
    handleShowDialogButton(photo, photoDialog)

    const emailCorpEditButton = document.querySelector("#salekaTopBarEmail")
    const emailCorpDialog = document.querySelector("#salekaTopbarEmailDiv")
    handleShowDialogButton(emailCorpEditButton, emailCorpDialog)

    const sloganCorpEditButton = document.querySelector("#salekaTopbarSlogan")
    const sloganCorpDialog = document.querySelector("#salekaTopbarSloganDiv")
    handleShowDialogButton(sloganCorpEditButton, sloganCorpDialog)

    const telCorpEditButton = document.querySelector("#salekaTopbarTel")
    const telDialog = document.querySelector("#salekaTopbarTelDiv")
    handleShowDialogButton(telCorpEditButton, telDialog)

    const heroTitreEditButton = document.querySelector("#salekaHeroTitre")
    const heroTitreDialog = document.querySelector("#salekaHeroTitreDiv")
    handleShowDialogButton(heroTitreEditButton, heroTitreDialog)

    const heroSousTitreEditButton = document.querySelector("#salekaHeroSousTitre")
    const heroSousTitreDialog = document.querySelector("#salekaHeroSousTitreDiv")
    handleShowDialogButton(heroSousTitreEditButton, heroSousTitreDialog)

    const bloc1WhyusTitreEditButton = document.querySelector("#salekaBloc1WhyusTitre")
    const bloc1WhyusTitreDialog = document.querySelector("#salekaBloc1WhyusTitreDiv")
    handleShowDialogButton(bloc1WhyusTitreEditButton,bloc1WhyusTitreDialog)

    const bloc1WhyusSousTitreEditButton = document.querySelector("#salekaBloc1WhyusSousTitre")
    const bloc1WhyusSousTitreDialog = document.querySelector("#salekaBloc1WhyusSousTitreDiv")
    handleShowDialogButton(bloc1WhyusSousTitreEditButton,bloc1WhyusSousTitreDialog)


    const salekaBloc2WhyusBoite1TitreEditButton = document.querySelector("#salekaBloc2WhyusBoite1Titre")
    const salekaBloc2WhyusBoite1TitreDialog = document.querySelector("#salekaBloc2WhyusBoite1TitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite1TitreEditButton,salekaBloc2WhyusBoite1TitreDialog)
    const salekaBloc2WhyusBoite1SousTitreEditButton = document.querySelector("#salekaBloc2WhyusBoite1SousTitre")
    const salekaBloc2WhyusBoite1SousTitreDialog = document.querySelector("#salekaBloc2WhyusBoite1SousTitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite1SousTitreEditButton,salekaBloc2WhyusBoite1SousTitreDialog)
    const salekaBloc2WhyusBoite2TitreEditButton = document.querySelector("#salekaBloc2WhyusBoite2Titre")
    const salekaBloc2WhyusBoite2TitreDialog = document.querySelector("#salekaBloc2WhyusBoite2TitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite2TitreEditButton,salekaBloc2WhyusBoite2TitreDialog)
    const salekaBloc2WhyusBoite2SousTitreEditButton = document.querySelector("#salekaBloc2WhyusBoite2SousTitre")
    const salekaBloc2WhyusBoite2SousTitreDialog = document.querySelector("#salekaBloc2WhyusBoite2SousTitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite2SousTitreEditButton,salekaBloc2WhyusBoite2SousTitreDialog)
    const salekaBloc2WhyusBoite3TitreEditButton = document.querySelector("#salekaBloc2WhyusBoite3Titre")
    const salekaBloc2WhyusBoite3TitreDialog = document.querySelector("#salekaBloc2WhyusBoite3TitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite3TitreEditButton,salekaBloc2WhyusBoite3TitreDialog)
    const salekaBloc2WhyusBoite3SousTitreEditButton = document.querySelector("#salekaBloc2WhyusBoite3SousTitre")
    const salekaBloc2WhyusBoite3SousTitreDialog = document.querySelector("#salekaBloc2WhyusBoite3SousTitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite3SousTitreEditButton,salekaBloc2WhyusBoite3SousTitreDialog)

    const salekaBloc1AboutVideoEditButton = document.querySelector("#salekaBloc1AboutVideo")
    const salekaBloc1AboutVideoDialog = document.querySelector("#salekaBloc1AboutVideoDiv")
    handleShowDialogButton(salekaBloc1AboutVideoEditButton,salekaBloc1AboutVideoDialog)

    const salekaBloc2AboutTitre1EditButton = document.querySelector("#salekaBloc2AboutTitre1")
    const salekaBloc2AboutTitre1Dialog =document.querySelector("#salekaBloc2AboutTitre1Div")
    handleShowDialogButton(salekaBloc2AboutTitre1EditButton,salekaBloc2AboutTitre1Dialog)

    const salekaBloc2AboutTitre2EditButton = document.querySelector("#salekaBloc2AboutTitre2")
    const salekaBloc2AboutTitre2Dialog = document.querySelector("#salekaBloc2AboutTitre2Div")
    handleShowDialogButton(salekaBloc2AboutTitre2EditButton,salekaBloc2AboutTitre2Dialog)

    const salekaBloc2AboutSousTitre2EditButton = document.querySelector("#salekaBloc2AboutSousTitre2")
    const salekaBloc2AboutSousTitre2Dialog = document.querySelector("#salekaBloc2AboutSousTitre2Div")
    handleShowDialogButton(salekaBloc2AboutSousTitre2EditButton,salekaBloc2AboutSousTitre2Dialog)

    const salekaBloc3AboutTitre1EditButton = document.querySelector("#salekaBloc3AboutTitre1")
    const  salekaBloc3AboutTitre1Dialog = document.querySelector("#salekaBloc3AboutTitre1Div")
    handleShowDialogButton(salekaBloc3AboutTitre1EditButton,salekaBloc3AboutTitre1Dialog)

    const salekaBloc3AboutTitre2EditButton = document.querySelector("#salekaBloc3AboutTitre2")
    const  salekaBloc3AboutTitre2Dialog = document.querySelector("#salekaBloc3AboutTitre2Div")
    handleShowDialogButton(salekaBloc3AboutTitre2EditButton,salekaBloc3AboutTitre2Dialog)

    const salekaBloc3AboutTitre3EditButton = document.querySelector("#salekaBloc3AboutTitre3")
    const  salekaBloc3AboutTitre3Dialog = document.querySelector("#salekaBloc3AboutTitre3Div")
    handleShowDialogButton(salekaBloc3AboutTitre3EditButton,salekaBloc3AboutTitre3Dialog)

    const salekaBloc3AboutSousTitre1EditButton = document.querySelector("#salekaBloc3AboutSousTitre1")
    const  salekaBloc3AboutSousTitre1Dialog = document.querySelector("#salekaBloc3AboutSousTitre1Div")
    handleShowDialogButton(salekaBloc3AboutSousTitre1EditButton,salekaBloc3AboutSousTitre1Dialog)

    const salekaBloc3AboutSousTitre2EditButton = document.querySelector("#salekaBloc3AboutSousTitre2")
    const  salekaBloc3AboutSousTitre2Dialog = document.querySelector("#salekaBloc3AboutSousTitre2Div")
    handleShowDialogButton(salekaBloc3AboutSousTitre2EditButton,salekaBloc3AboutSousTitre2Dialog)

    const salekaBloc3AboutSousTitre3EditButton = document.querySelector("#salekaBloc3AboutSousTitre3")
    const  salekaBloc3AboutSousTitre3Dialog = document.querySelector("#salekaBloc3AboutSousTitre3Div")
    handleShowDialogButton(salekaBloc3AboutSousTitre3EditButton,salekaBloc3AboutSousTitre3Dialog)

    const salekatitreServiceEditButton = document.querySelector("#salekatitreService")
    const salekatitreServiceDialog = document.querySelector("#salekatitreServiceDiv")
    handleShowDialogButton(salekatitreServiceEditButton,salekatitreServiceDialog)

    initshowDialog("salekadescriptionService")
    initshowDialog("salekabloc1ServiceTitre1")
    initshowDialog("salekabloc1ServiceSoustitre1")
    initshowDialog("salekabloc1ServiceTitre2")
    initshowDialog("salekabloc1ServiceSoustitre2")
    initshowDialog("salekabloc1ServiceTitre3")
    initshowDialog("salekabloc1ServiceSoustitre3")
    initshowDialog("salekaourMissionTitre")
    initshowDialog("salekaourMissionDescription")
    initshowDialog("salekaourPlanTitre")
    initshowDialog("salekaourPlanDescription")
    initshowDialog("salekaadresse")
    initshowDialog("salekacontactDescription")
    initshowDialog("salekanewsletterDescription")
})();

function initshowDialog(value) {
    const editbutton = document.querySelector("#"+value)
    const  dialog = document.querySelector("#"+value+"Div")
    handleShowDialogButton(editbutton,dialog)
}

function handleShowDialogButton(btnElement, dialogBox){
    if (dialogBox){
        let cancelButton = dialogBox.querySelector('.cancel')
        if (btnElement){
            btnElement.addEventListener('click', (event) => {
                event.preventDefault()
                console.log(btnElement,dialogBox)
                $(dialogBox).toggle();
            })}
        if (cancelButton){
            cancelButton.addEventListener('click', evt => {
                evt.preventDefault()
                console.log("j'ai cliqué sur annuler")
                $(dialogBox).toggle();
            })
        }
    }

}


(function() {
    const setImageAsDefaultButton = document.querySelector("#setBackgroundHome")
    if (setImageAsDefaultButton){
        setImageAsDefaultButton.addEventListener('click', evt => {
            evt.preventDefault()
            console.log('clique definir')
        })
    }

})();

const previewImage = function (fileInput , myElement) {
    //console.log('test preview');
    var file = fileInput.files[0];
    var filesCount = $(fileInput)[0].files.length;
    debugger
    if(filesCount === 1){
        var textBox = $(fileInput).prev();
        var fileName = $(fileInput).val().split('\\').pop();
        textBox.text(fileName);
    }else{
        return;
    }
    if (typeof (FileReader) != "undefined") {
        var previewImg = $(''+myElement.toString());
        previewImg.html("");
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = $("<img />");
            img.attr("style", "width: 150px; height:100px; padding: 10px");
            img.attr("src", e.target.result);
            previewImg.append(img);
        };
        reader.readAsDataURL(file);
    }else {
        alert("This browser does not support HTML5 FileReader.");
    }
}

/*
const handlePreview = function() {
    var filesCount = $(this)[0].files.length;
    var textbox = $(this).prev();

    if (filesCount === 1) {
        var fileName = $(this).val().split('\\').pop();
        textbox.text(fileName);
    } else {
        textbox.text(filesCount + ' files selected');
    }

    if (typeof (FileReader) != "undefined") {
        var dvPreview = $("#divImageMediaPreview");
        dvPreview.html("");
        $($(this)[0].files).each(function () {
            var file = $(this);
            var reader = new FileReader();
            reader.onload = function (e) {
                var img = $("<img />");
                img.attr("style", "width: 150px; height:100px; padding: 10px");
                img.attr("src", e.target.result);
                dvPreview.append(img);
                dvPreviewBlog.append(img);
            }
            reader.readAsDataURL(file[0]);
        });
    } else {
        alert("This browser does not support HTML5 FileReader.");
    }

}
*/

$('#exampleInputFile').change(function () {
    previewImage(this , '#divImageMediaPreview');
})

//$(document).on('change', '#exampleInputFile', previewImage(this , '#profilePreview') );
