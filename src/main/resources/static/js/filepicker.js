
const client = filestack.init(fileStackApi);
let imgUrl = document.getElementById("imgurl");

const options = {

    onFileUploadFinished:file =>{
        imgUrl.value = file.url;
        console.log("FileUpload file url:"+file.url);
        console.log("FileUpload file size:"+file.size);
    }
};

client.picker(options).open();