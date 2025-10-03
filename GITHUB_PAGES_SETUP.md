# 🚀 GitHub Pages Setup Guide

## Making Your Game Playable Online!

This guide will show you how to deploy "Follow the White Rabbit v2" to GitHub Pages so anyone can play it directly in their browser.

---

## Option 1: Quick Setup (Recommended)

### Step 1: Create a GitHub Repository

1. Go to https://github.com/new
2. Name your repository: `follow-the-white-rabbit`
3. Make it **Public** (required for free GitHub Pages)
4. **Don't** initialize with README (we already have one)
5. Click "Create repository"

### Step 2: Upload Your Files

**Via GitHub Web Interface (Easiest):**

1. On your new repository page, click **"uploading an existing file"**
2. Drag and drop ALL these files:
   - `index.html` ⭐ (This is the web version!)
   - `WhiteRabbit.java`
   - `README.md`
   - `QUICKSTART.md`
   - `run.bat`
   - `run.sh`
3. Scroll down and click **"Commit changes"**

**Via Command Line (If you prefer):**

```bash
cd "C:\Users\Squir\Desktop\follow the white rabbit v2"
git init
git add .
git commit -m "Initial commit: Follow the White Rabbit v2"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/follow-the-white-rabbit.git
git push -u origin main
```

### Step 3: Enable GitHub Pages

1. Go to your repository on GitHub
2. Click **Settings** (top right)
3. Click **Pages** (left sidebar)
4. Under "Source", select **main** branch
5. Keep the folder as **/ (root)**
6. Click **Save**
7. Wait 1-2 minutes for deployment

### Step 4: Get Your Live URL

Your game will be live at:
```
https://YOUR_USERNAME.github.io/follow-the-white-rabbit/
```

Replace `YOUR_USERNAME` with your actual GitHub username.

---

## Option 2: Custom Domain (Advanced)

If you have your own domain:

1. Follow all steps in Option 1
2. In GitHub Pages settings, add your custom domain
3. Update your domain's DNS records (see GitHub's guide)

---

## Testing Your Deployment

1. Open your GitHub Pages URL in a browser
2. You should see the game start screen with "WAKE UP" button
3. Click "WAKE UP" and start playing!
4. Make sure all choices work and endings appear correctly

---

## Troubleshooting

### "404 - Page Not Found"
- Wait a few more minutes - deployment can take up to 10 minutes
- Make sure `index.html` is in the root folder (not in a subfolder)
- Check that GitHub Pages is enabled in Settings

### Game doesn't start
- Open browser console (F12) and check for errors
- Make sure you uploaded `index.html` (not just README.md)
- Try a hard refresh: Ctrl+Shift+R (Windows) or Cmd+Shift+R (Mac)

### Styling looks broken
- Clear your browser cache
- Make sure all the CSS is embedded in `index.html`

---

## Sharing Your Game

Once deployed, share your game:

### On GitHub README
Your `README.md` already has great documentation. Add a "Play Now" link at the top:

```markdown
# 🐰 Follow the White Rabbit v2

▶️ **[PLAY NOW](https://YOUR_USERNAME.github.io/follow-the-white-rabbit/)** ◀️

> *"I imagine right now you're feeling a bit like Alice..."*
```

### Social Media
Share with:
- Direct link to your GitHub Pages URL
- Screenshot of the game terminal
- Text: "Just deployed an interactive Matrix × Alice in Wonderland text adventure! Play in your browser: [link]"

### Reddit / Forums
Great subreddits to share:
- r/incremental_games
- r/webgames
- r/InteractiveFiction
- r/textventures

---

## Updating Your Game

When you make changes:

1. Edit `index.html` locally
2. Go to your GitHub repository
3. Click on `index.html`
4. Click the pencil icon (Edit)
5. Paste your new code
6. Click "Commit changes"
7. Wait 1-2 minutes and your live site will update!

---

## File Structure for GitHub

Your repository should look like:

```
follow-the-white-rabbit/
├── index.html              ⭐ Main web game (GitHub Pages uses this)
├── WhiteRabbit.java        💻 Java terminal version
├── README.md               📖 Documentation
├── QUICKSTART.md           🚀 Quick start guide
├── run.bat                 🪟 Windows launcher
├── run.sh                  🐧 Linux/Mac launcher
└── GITHUB_PAGES_SETUP.md   📝 This file
```

---

## Two Versions, One Repo!

This repository now offers **TWO ways to play**:

### 🌐 Web Version (GitHub Pages)
- Play instantly in browser
- No installation needed
- Share with anyone via URL
- Perfect for quick demos
- **URL:** `https://YOUR_USERNAME.github.io/follow-the-white-rabbit/`

### 💻 Terminal Version (Java)
- Download and compile WhiteRabbit.java
- Run in command line/terminal
- Original terminal experience
- For developers and CLI enthusiasts
- **Instructions:** See QUICKSTART.md

---

## Example Repository URL

If your GitHub username is `ringmast4r`, your setup would be:

- **Repository:** https://github.com/ringmast4r/follow-the-white-rabbit
- **Live Game:** https://ringmast4r.github.io/follow-the-white-rabbit/
- **Source Code:** Browse on GitHub

---

## Success Checklist

- [ ] Repository created on GitHub
- [ ] All files uploaded (especially `index.html`)
- [ ] GitHub Pages enabled in Settings → Pages
- [ ] Waited 2-10 minutes for deployment
- [ ] Visited the GitHub Pages URL
- [ ] Game starts and is playable
- [ ] Shared link with friends!

---

## Need Help?

- **GitHub Pages Docs:** https://docs.github.com/pages
- **Check deployment status:** Repository → Settings → Pages
- **View build logs:** Repository → Actions tab

---

*Once deployed, anyone in the world can play your game with just a click! 🐰✨*
