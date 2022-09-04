import { initializeApp } from "firebase/app"; 
import { getFirestore } from "firebase/firestore"; 
import { getAuth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from "firebase/auth";

const firebaseConfig = {
  apiKey: process.env.REACT_APP_API_KEY,
  authDomain: process.env.REACT_APP_AUTH_DOMAIN,
  projectId: process.env.REACT_APP_PROJECT_ID,
  storageBucket: process.env.REACT_APP_STORAGE_BUCKET,
  messagingSenderId: process.env.REACT_APP_MESSAGING_ID,
  appId: process.env.REACT_APP_APP_ID
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const database = getFirestore(app);
 
const auth = getAuth();
console.log(auth);

auth.onAuthStateChanged(user=>{
  if(user){
    signInWithEmailAndPassword(auth, 'hanzen927@gmai.com','hAribo2021!@')
    .then((userCredential)=>{
      const user = userCredential.user
      console.log(user);
    })
    .catch((error)=>{
      console.log(error);
    })
  } else {
    createUserWithEmailAndPassword(auth, 'hanzen927@gmail.com','hAribo2021!@').then((userCredential)=>{
      signInWithEmailAndPassword(auth, 'hanzen927@gmail.com','hAribo2021!@')
      .then((userCredential)=>{
        const user = userCredential.user
        console.log(user);
      })
      .catch((error)=>{
        console.log(error);
      })
    })
    .catch((error)=>{
      console.log(error);
    })
  }
});

export default database;

