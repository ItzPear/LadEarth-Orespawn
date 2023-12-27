/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelBattleAxe
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Handle1;
/*     */   ModelRenderer Head1;
/*     */   ModelRenderer Grip;
/*     */   ModelRenderer Pin;
/*     */   ModelRenderer Top;
/*     */   ModelRenderer Blade1;
/*     */   ModelRenderer Blade2;
/*     */   ModelRenderer Blade3;
/*     */   ModelRenderer Blade4;
/*     */   ModelRenderer Blade5;
/*     */   ModelRenderer Blade6;
/*     */   ModelRenderer Blade7;
/*     */   ModelRenderer Blade8;
/*     */   ModelRenderer Blade9;
/*     */   ModelRenderer Blade10;
/*     */   
/*     */   public ModelBattleAxe() {
/*  29 */     this.textureWidth = 128;
/*  30 */     this.textureHeight = 64;
/*     */     
/*  32 */     this.Handle1 = new ModelRenderer(this, 0, 0);
/*  33 */     this.Handle1.addBox(-7.0F, -0.5F, 0.0F, 31, 2, 1);
/*  34 */     this.Handle1.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  35 */     this.Handle1.setTextureSize(128, 64);
/*  36 */     this.Handle1.mirror = true;
/*  37 */     setRotation(this.Handle1, 0.0F, 0.0F, 1.570796F);
/*  38 */     this.Head1 = new ModelRenderer(this, 29, 18);
/*  39 */     this.Head1.addBox(-2.0F, -4.5F, -0.5F, 3, 4, 2);
/*  40 */     this.Head1.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  41 */     this.Head1.setTextureSize(128, 64);
/*  42 */     this.Head1.mirror = true;
/*  43 */     setRotation(this.Head1, 0.0F, 0.0F, 0.0F);
/*  44 */     this.Grip = new ModelRenderer(this, 0, 7);
/*  45 */     this.Grip.addBox(-1.92F, 13.0F, -0.5F, 3, 11, 2);
/*  46 */     this.Grip.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  47 */     this.Grip.setTextureSize(128, 64);
/*  48 */     this.Grip.mirror = true;
/*  49 */     setRotation(this.Grip, 0.0F, 0.0F, 0.0F);
/*  50 */     this.Pin = new ModelRenderer(this, 38, 11);
/*  51 */     this.Pin.addBox(-1.0F, -3.0F, -1.0F, 1, 1, 3);
/*  52 */     this.Pin.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  53 */     this.Pin.setTextureSize(128, 64);
/*  54 */     this.Pin.mirror = true;
/*  55 */     setRotation(this.Pin, 0.0F, 0.0F, 0.0F);
/*  56 */     this.Top = new ModelRenderer(this, 24, 11);
/*  57 */     this.Top.addBox(-2.0F, -8.0F, -0.5F, 3, 2, 2);
/*  58 */     this.Top.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  59 */     this.Top.setTextureSize(128, 64);
/*  60 */     this.Top.mirror = true;
/*  61 */     setRotation(this.Top, 0.0F, 0.0F, 0.0F);
/*  62 */     this.Blade1 = new ModelRenderer(this, 70, 0);
/*  63 */     this.Blade1.addBox(6.0F, -8.0F, 0.0F, 3, 10, 1);
/*  64 */     this.Blade1.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  65 */     this.Blade1.setTextureSize(128, 64);
/*  66 */     this.Blade1.mirror = true;
/*  67 */     setRotation(this.Blade1, 0.0F, 0.0F, 0.5061455F);
/*  68 */     this.Blade2 = new ModelRenderer(this, 70, 0);
/*  69 */     this.Blade2.addBox(8.5F, -6.9F, 0.0F, 3, 10, 1);
/*  70 */     this.Blade2.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  71 */     this.Blade2.setTextureSize(128, 64);
/*  72 */     this.Blade2.mirror = true;
/*  73 */     setRotation(this.Blade2, 0.0F, 0.0F, -0.5061455F);
/*  74 */     this.Blade3 = new ModelRenderer(this, 0, 0);
/*  75 */     this.Blade3.addBox(-1.5F, -3.0F, 0.0F, 10, 1, 1);
/*  76 */     this.Blade3.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  77 */     this.Blade3.setTextureSize(128, 64);
/*  78 */     this.Blade3.mirror = true;
/*  79 */     setRotation(this.Blade3, 0.0F, 0.0F, 0.0F);
/*  80 */     this.Blade4 = new ModelRenderer(this, 0, 0);
/*  81 */     this.Blade4.addBox(-1.0F, -2.0F, 0.0F, 7, 1, 1);
/*  82 */     this.Blade4.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  83 */     this.Blade4.setTextureSize(128, 64);
/*  84 */     this.Blade4.mirror = true;
/*  85 */     setRotation(this.Blade4, 0.0F, 0.0F, 0.5061455F);
/*  86 */     this.Blade5 = new ModelRenderer(this, 0, 0);
/*  87 */     this.Blade5.addBox(0.5F, -3.5F, 0.0F, 8, 1, 1);
/*  88 */     this.Blade5.setRotationPoint(0.0F, -12.0F, 0.0F);
/*  89 */     this.Blade5.setTextureSize(128, 64);
/*  90 */     this.Blade5.mirror = true;
/*  91 */     setRotation(this.Blade5, 0.0F, 0.0F, -0.5061455F);
/*  92 */     this.Blade6 = new ModelRenderer(this, 70, 0);
/*  93 */     this.Blade6.addBox(-12.2F, -5.2F, 0.0F, 3, 10, 1);
/*  94 */     this.Blade6.setRotationPoint(0.0F, -13.0F, 0.0F);
/*  95 */     this.Blade6.setTextureSize(128, 64);
/*  96 */     this.Blade6.mirror = true;
/*  97 */     setRotation(this.Blade6, 0.0F, 0.0F, 0.5061455F);
/*  98 */     this.Blade7 = new ModelRenderer(this, 0, 0);
/*  99 */     this.Blade7.addBox(-9.9F, -3.0F, 0.0F, 8, 1, 1);
/* 100 */     this.Blade7.setRotationPoint(0.0F, -12.0F, 0.0F);
/* 101 */     this.Blade7.setTextureSize(128, 64);
/* 102 */     this.Blade7.mirror = true;
/* 103 */     setRotation(this.Blade7, 0.0F, 0.0F, 0.5061455F);
/* 104 */     this.Blade8 = new ModelRenderer(this, 0, 0);
/* 105 */     this.Blade8.addBox(-10.0F, -3.0F, 0.0F, 10, 1, 1);
/* 106 */     this.Blade8.setRotationPoint(0.0F, -12.0F, 0.0F);
/* 107 */     this.Blade8.setTextureSize(128, 64);
/* 108 */     this.Blade8.mirror = true;
/* 109 */     setRotation(this.Blade8, 0.0F, 0.0F, 0.0F);
/* 110 */     this.Blade9 = new ModelRenderer(this, 70, 0);
/* 111 */     this.Blade9.addBox(-10.0F, -8.5F, 0.0F, 3, 10, 1);
/* 112 */     this.Blade9.setRotationPoint(0.0F, -12.0F, 0.0F);
/* 113 */     this.Blade9.setTextureSize(128, 64);
/* 114 */     this.Blade9.mirror = true;
/* 115 */     setRotation(this.Blade9, 0.0F, 0.0F, -0.5061455F);
/* 116 */     this.Blade10 = new ModelRenderer(this, 0, 0);
/* 117 */     this.Blade10.addBox(-7.0F, -2.5F, 0.0F, 7, 1, 1);
/* 118 */     this.Blade10.setRotationPoint(0.0F, -12.0F, 0.0F);
/* 119 */     this.Blade10.setTextureSize(128, 64);
/* 120 */     this.Blade10.mirror = true;
/* 121 */     setRotation(this.Blade10, 0.0F, 0.0F, -0.5061455F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/* 126 */     float f5 = 1.0F;
/*     */     
/* 128 */     this.Handle1.render(f5);
/* 129 */     this.Head1.render(f5);
/* 130 */     this.Grip.render(f5);
/* 131 */     this.Pin.render(f5);
/* 132 */     this.Top.render(f5);
/* 133 */     this.Blade1.render(f5);
/* 134 */     this.Blade2.render(f5);
/* 135 */     this.Blade3.render(f5);
/* 136 */     this.Blade4.render(f5);
/* 137 */     this.Blade5.render(f5);
/* 138 */     this.Blade6.render(f5);
/* 139 */     this.Blade7.render(f5);
/* 140 */     this.Blade8.render(f5);
/* 141 */     this.Blade9.render(f5);
/* 142 */     this.Blade10.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 147 */     model.rotateAngleX = x;
/* 148 */     model.rotateAngleY = y;
/* 149 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelBattleAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */